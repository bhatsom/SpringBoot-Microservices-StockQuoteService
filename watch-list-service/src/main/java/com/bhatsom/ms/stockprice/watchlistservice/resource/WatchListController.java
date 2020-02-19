package com.bhatsom.ms.stockprice.watchlistservice.resource;

import com.bhatsom.ms.stockprice.watchlistservice.model.UserTicker;
import com.bhatsom.ms.stockprice.watchlistservice.repository.WatchListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/watchlist")
public class WatchListController {

    private WatchListRepository watchListRepository;

    public WatchListController(WatchListRepository watchListRepository) {
        this.watchListRepository = watchListRepository;
    }

    @GetMapping("/{username}")
    public List<String> getTickers(@PathVariable("username") final String username) {

        return getWatchListByUser(username);
    }

    @PostMapping("/addTicker")
    public List<String> addTickerToWatchList(@RequestBody final UserTicker userTicker) {
        /*userTicker.getQuotes()
                .stream()
                .map(quote -> new UserTickers(quotes.getUserName(), quote))
                .forEach(quote -> watchListRepository.save(quote));*/
        watchListRepository.save(userTicker);
        return getWatchListByUser(userTicker.getUserName());
    }


    @PostMapping("/deleteTicker")
    public List<String> delete(@PathVariable("username") final UserTicker userTicker) {

        //List<UserTicker> userTickers = watchListRepository.findByUserName(userTicker.getUserName());
        watchListRepository.delete(userTicker);
        return getWatchListByUser(userTicker.getUserName());
    }


    private List<String> getWatchListByUser(@PathVariable("username") String username) {
        return watchListRepository.findByUserName(username)
                .stream()
                .map(UserTicker::getTikcer)
                .collect(Collectors.toList());
        //return watchListRepository.findByUserName(username);
    }

}
