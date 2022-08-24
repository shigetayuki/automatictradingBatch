package jp.mydns.automatictradingbatch.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jp.mydns.automatictradingbatch.entity.TradeSystem;
import jp.mydns.automatictradingbatch.repository.TradeSystemRepository;

@Repository
public class TradeSystemDao {

    @Autowired
	private TradeSystemRepository repository;

    public List<TradeSystem> getMxList(){
        return repository.getMxList();
    }
}
