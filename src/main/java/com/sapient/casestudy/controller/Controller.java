package com.sapient.casestudy.controller;

import com.sapient.casestudy.response.StandingResponse;
import com.sapient.casestudy.service.StandingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    StandingService standingService;

    @GetMapping("/api/standings")
    @ResponseBody
    public StandingResponse findOne(@RequestParam String country, @RequestParam String league, @RequestParam String team) {
        return standingService.getStandings(country, league, team);
    }
}

