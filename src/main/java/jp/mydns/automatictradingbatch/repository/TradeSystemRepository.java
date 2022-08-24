package jp.mydns.automatictradingbatch.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jp.mydns.automatictradingbatch.constant.SQL_CONST;
import jp.mydns.automatictradingbatch.entity.TradeSystem;

@Repository
public interface TradeSystemRepository extends JpaRepository<TradeSystem, Long> {
    @Query(value= SQL_CONST.R001,nativeQuery = true)
    List<TradeSystem> getMxList();
}
