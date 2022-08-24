package jp.mydns.automatictradingbatch.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Service;

@Service
public class ProcessorService {

    public String authentication(String user, String password, String url) throws IOException, InterruptedException {
        // HttpClientを生成
        HttpClient cli = HttpClient.newBuilder().build();

        // HttpRequestを生成
        HttpRequest req = HttpRequest.newBuilder()
        .uri(URI.create(url+"login"))
        .header("Content-Type","application/json")
        .POST(HttpRequest.BodyPublishers.ofString(
            "{ \"userName\" : "+user+" ,\"password\":"+password+" }")
        ).build();

        // リクエストを送信
        HttpResponse<String> res = cli.send(req, HttpResponse.BodyHandlers.ofString());
        //レスポンス
        String token =res.headers().map().get("Authorization").get(0);
        
        return token;
    }
    
}
