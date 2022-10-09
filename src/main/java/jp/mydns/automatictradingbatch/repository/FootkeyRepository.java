package jp.mydns.automatictradingbatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.mydns.automatictradingbatch.entity.Footkey;


@Repository
public interface FootkeyRepository  extends JpaRepository<Footkey, Long> {
    
}
