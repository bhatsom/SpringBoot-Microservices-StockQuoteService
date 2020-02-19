package com.bhatsom.ms.stockprice.watchlistservice.model;

import javax.persistence.*;

@Entity
//@Table(name = "User_Ticker_Mapping", catalog = "test")
@Table(name = "User_Ticker_Mapping") // use default schema for H2
public class UserTicker {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO) // use AUTO or MySQL
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue // H2 uses strategy = GenerationType.IDENTITY by default
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "tikcer")
    private String tikcer;

    public UserTicker() {
    }

    public UserTicker(String userName, String tikcer) {
        this.userName = userName;
        this.tikcer = tikcer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTikcer() {
        return tikcer;
    }

    public void setTikcer(String tikcer) {
        this.tikcer = tikcer;
    }
}
