package jp.mydns.automatictradingbatch.service;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import jp.mydns.automatictradingbatch.entity.TradeSystem;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProcessorService {

    public String authentication(String user, String password, String url) throws IOException, InterruptedException {
        // HttpClientを生成
        HttpClient cli = HttpClient.newBuilder().build();

        // HttpRequestを生成
        HttpRequest req = HttpRequest.newBuilder()
        .uri(URI.create(url+"login"))
        .header("Content-Type", "application/json;charset=utf-8")
        .POST(HttpRequest.BodyPublishers.ofString("{\"userName\":\"" + user + "\",\"password\":\""+ password +"\"}"))
        .build();

        // リクエストを送信
        HttpResponse<String> res = cli.send(req, HttpResponse.BodyHandlers.ofString());
        //レスポンス
        String token =res.headers().map().get("Authorization").get(0);
        
        return token;
    }

    public void sendData(List<TradeSystem> item,String url, String token) throws Exception {
        // HttpClientを生成
        HttpClient cli = HttpClient.newBuilder().build();

        // HttpRequestを生成
        HttpRequest req = HttpRequest.newBuilder()
        .uri(URI.create(url+"setTradeData"))
        .setHeader("Authorization", token)
        .POST(HttpRequest.BodyPublishers.ofString(new ObjectMapper().writeValueAsString(item)))
        .build();
        
        // リクエストを送信
        HttpResponse<String> res = cli.send(req, HttpResponse.BodyHandlers.ofString());
        //レスポンス
        String body =res.body();

        if(!"OK".equals(body)){
            log.info(body);
            throw new Exception(body);
        }
    }
    
}
