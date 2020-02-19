package com.bhatsom.ms.stockprice.watchlistservice.model;

import java.util.List;

public class WatchList {

    private String userName;
    private List<String> tickers;

    public WatchList() {
    }

    public WatchList(String userName, List<String> tickers) {
        this.userName = userName;
        this.tickers = tickers;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getTickers() {
        return tickers;
    }

    public void setTickers(List<String> tickers) {
        this.tickers = tickers;
    }

}
