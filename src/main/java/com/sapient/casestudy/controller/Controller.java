package com.sapient.casestudy.controller;

import com.sapient.casestudy.response.StandingFbResponse;
import com.sapient.casestudy.service.StandingFbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    StandingFbService standingService;

    @RequestMapping(
            value = {"/api/standing/{countryName}/{leagueName}/{teamName}"},
            method = {RequestMethod.GET}
    )
    @ResponseBody
    public StandingFbResponse findOne(@PathVariable(value = "countryName", required = true) String countryName,
                                      @PathVariable(value = "leagueName", required = true) String leagueName,
                                      @PathVariable(value = "teamName", required = true) String teamName) {
        return standingService.getStandings(countryName, leagueName, teamName);
    }
}

