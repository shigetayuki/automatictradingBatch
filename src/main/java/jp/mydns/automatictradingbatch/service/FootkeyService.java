package jp.mydns.automatictradingbatch.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.mydns.automatictradingbatch.entity.Footkey;
import jp.mydns.automatictradingbatch.entity.TradeSystem;
import jp.mydns.automatictradingbatch.repository.FootkeyRepository;


@Service
public class FootkeyService {

    @Autowired
    private FootkeyRepository repository;
    
    public void updateFootkeySendFlg(List<TradeSystem> items){
        List<Footkey> footkeyList = new ArrayList<>();

        for(TradeSystem item:items){
            Footkey footkey = new Footkey();
            footkey.setFkId(item.getFkId());
            footkey.setFkDate(item.getFkDate());
            footkey.setFkTime(item.getFkTime());
            footkey.setPrice(item.getPrice());
            footkey.setTrend(item.getTrend());
            footkey.setMountain(item.getMountain());
            footkey.setValley(item.getValley());
            footkey.setSendFlg("1");
            footkeyList.add(footkey);
        }
        
        repository.saveAll(footkeyList);
    }
}
