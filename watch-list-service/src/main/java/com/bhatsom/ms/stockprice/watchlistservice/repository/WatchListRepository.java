package com.bhatsom.ms.stockprice.watchlistservice.repository;

import com.bhatsom.ms.stockprice.watchlistservice.model.UserTicker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WatchListRepository extends JpaRepository<UserTicker, String> {
    List<UserTicker> findByUserName(String username);
}
