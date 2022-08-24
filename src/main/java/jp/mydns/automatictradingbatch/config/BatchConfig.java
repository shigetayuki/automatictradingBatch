package jp.mydns.automatictradingbatch.config;

import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jp.mydns.automatictradingbatch.entity.TradeSystem;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
    
    /**JobBuilderのFactoryクラス */
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    /**StepBuilderのFactoryクラス */
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    /**readerクラス */
    @Autowired
    private ItemReader<List<TradeSystem>> reader;

    /**processorクラス */
    @Autowired
    private ItemProcessor<List<TradeSystem>,List<TradeSystem>> processor;

    /**writterクラス */
    @Autowired
    private ItemWriter<List<TradeSystem>> writer;

    @Bean
    public Step chunkStep(){
        return stepBuilderFactory.get("automatictradingChunkStep")
            .<List<TradeSystem>,List<TradeSystem>>chunk(1)
            .reader(reader)
            .processor(processor)
            .writer(writer)
            .build();
    }

    @Bean
    public Job chunkJob(){
        return jobBuilderFactory.get("automaticTradingChunkJob")
            .incrementer(new RunIdIncrementer())
            .start(chunkStep())
            .build();
    }
}
