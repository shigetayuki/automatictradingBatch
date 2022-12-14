package jp.mydns.automatictradingbatch.chunk;

import java.util.List;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.mydns.automatictradingbatch.entity.TradeSystem;
import jp.mydns.automatictradingbatch.service.FootkeyService;
import lombok.extern.slf4j.Slf4j;

@Component
@StepScope
@Slf4j
public class BatchWriter implements ItemWriter<List<TradeSystem>>{
    @Autowired
    private FootkeyService service;

    @Override
    public void write(List<? extends List<TradeSystem>> items) throws Exception {
        log.info("writer:{}",items);
        
        service.updateFootkeySendFlg(items.get(0));
    }
    
}
