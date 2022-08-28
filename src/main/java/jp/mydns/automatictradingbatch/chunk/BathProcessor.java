package jp.mydns.automatictradingbatch.chunk;

import java.util.List;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jp.mydns.automatictradingbatch.entity.TradeSystem;
import jp.mydns.automatictradingbatch.service.ProcessorService;
import lombok.extern.slf4j.Slf4j;

@Component
@StepScope
@Slf4j
public class BathProcessor implements ItemProcessor<List<TradeSystem>,List<TradeSystem>> {
    @Value("${authentication.user}")
    private String user;

    @Value("${authentication.password}")
    private String password;

    @Value("${server.url}")
    private String url;

    @Autowired
    private ProcessorService service;

    @Override
    public List<TradeSystem> process(List<TradeSystem> item) throws Exception {
        log.info("processor:{}",item);

        //認証処理
        String token = service.authentication(user,password,url);
        //送信処理
        boolean sendFlg = service.sendData(item,url,token);

        //エンティティの値更新
        if(sendFlg){
            for(TradeSystem ts :item){
                ts.setSendFlg("1");
            }
        }
        return item;
    }
    
}
