package com.sapient.casestudy.controller;

import com.sapient.casestudy.response.StandingResponse;
import com.sapient.casestudy.service.StandingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    StandingService standingService;

    @RequestMapping(
            value = {"/api/standing/{countryName}/{leagueName}/{teamName}"},
            method = {RequestMethod.GET}
    )
    @ResponseBody
    public StandingResponse findOne(@PathVariable(value = "countryName", required = true) String countryName,
                                    @PathVariable(value = "leagueName", required = true) String leagueName,
                                    @PathVariable(value = "teamName", required = true) String teamName) {
        return standingService.getStandings(countryName, leagueName, teamName);
    }
}

