package com.bhatsom.ms.stockprice.watchlistservice.repository;

import com.bhatsom.ms.stockprice.watchlistservice.model.UserTicker;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class WatchListRepositoryInMemory {

    private Map<String, List<String>> userTickerMapping;

    @PostConstruct
    public void init(){
        userTickerMapping = new HashMap<>();

        List<String> userOneList = new ArrayList<>();
        userOneList.addAll(Arrays.asList("AAPL", "GOOG", "IBM"));
        userTickerMapping.put("user1", userOneList);

        List<String> userTwoList = new ArrayList<>();
        userTwoList.addAll(Arrays.asList("AMZN", "GOOG", "MSFT"));
        userTickerMapping.put("user2", userTwoList);
    }

    public List<String> findByUserName(String username){
        List<String> tickers = userTickerMapping.get(username);
        if(tickers == null)
            tickers = new ArrayList<>();
        return tickers;
    }

    public List<String> save(final UserTicker userTicker){
        List<String> tickers = userTickerMapping.get(userTicker.getUserName());
        if(tickers == null) {
            tickers = new ArrayList<>();
            tickers.add(userTicker.getTikcer());
            userTickerMapping.putIfAbsent(userTicker.getUserName(), tickers);
        } else {
            tickers.add(userTicker.getTikcer());
        }
        return tickers;
    }


    public List<String> delete(final UserTicker userTicker){
        List<String> tickers = userTickerMapping.get(userTicker.getUserName());
        if(tickers == null) {
            throw new IllegalArgumentException("User doesn't exist");
        } else {
            tickers.remove(userTicker.getTikcer());
        }
        return tickers;
    }

}
