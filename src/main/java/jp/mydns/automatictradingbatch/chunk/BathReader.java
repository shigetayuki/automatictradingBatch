package jp.mydns.automatictradingbatch.chunk;

import java.util.List;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.mydns.automatictradingbatch.entity.TradeSystem;
import jp.mydns.automatictradingbatch.service.TradeSystemService;
import lombok.extern.slf4j.Slf4j;

@Component
@StepScope
@Slf4j
public class BathReader implements ItemReader<List<TradeSystem>> {
    @Autowired
    private TradeSystemService service;

    @Override
    public List<TradeSystem> read()
            throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        
                log.info("reader:start");

        return service.getMxList();
    }

    
}
