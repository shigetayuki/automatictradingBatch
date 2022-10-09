package jp.mydns.automatictradingbatch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.mydns.automatictradingbatch.dao.TradeSystemDao;
import jp.mydns.automatictradingbatch.entity.TradeSystem;


@Service
public class TradeSystemService {
    @Autowired
    private TradeSystemDao dao;

    public List<TradeSystem> getMxList(){
        List<TradeSystem> systemList = null;
        try{
            systemList = dao.getMxList();
            
            if(systemList.size()==0){
                systemList = null;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return systemList;
    }
}
