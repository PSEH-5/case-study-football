package com.sapient.casestudy.service;

import com.sapient.casestudy.connector.ApiConnector;
import com.sapient.casestudy.exception.CaseStudyFbException;
import com.sapient.casestudy.response.StandingFbResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StandingFbService {

    @Autowired
    ApiConnector apiConnector;

    public StandingFbResponse getStandings(String countryName, String leagueName, String teamName) {
        StandingFbResponse standingResponse = new StandingFbResponse();

        List<Map> countries = apiConnector.getCountries();
        String countryId = getCountryIdByName(countries, countryName);
        verifyNullAndThrowException("countryId", countryId);

        standingResponse.setCountry_id(countryId);
        standingResponse.setCountry_name(countryName);

        List<Map> leagues = apiConnector.getLeagues(countryId);
        String leagueId = getLeagueIdByName(leagues, leagueName);
        verifyNullAndThrowException("leagueId", leagueId);

        standingResponse.setLeague_id(leagueId);
        standingResponse.setLeague_name(leagueName);

        List<Map> standings = apiConnector.getStandings(leagueId);
        Map<String, String> standing = getStandingByTeamName(standings, teamName);
        verifyNullAndThrowException("standing", standing);

        standingResponse.setTeam_id(standing.get("team_id"));
        standingResponse.setTeam_name(standing.get("team_name"));
        standingResponse.setOverall_league_position(standing.get("overall_league_position"));

        return standingResponse;
    }

    private String getCountryIdByName(List<Map> countries, String countryName) {
        String countryId = null;
        for (Map<String, String> country : countries) {
            if (countryName.equalsIgnoreCase(country.get("country_name"))) {
                countryId = country.get("country_id");
                break;
            }
        }
        return countryId;
    }

    private String getLeagueIdByName(List<Map> leagues, String leagueName) {
        String leagueId = null;
        for (Map<String, String> league : leagues) {
            if (leagueName.equalsIgnoreCase(league.get("league_name"))) {
                leagueId = league.get("league_id");
                break;
            }
        }
        return leagueId;
    }

    private Map<String, String> getStandingByTeamName(List<Map> standings , String teamName){
        for (Map<String, String> s : standings) {
            if (teamName.equalsIgnoreCase(s.get("team_name"))) {
                return s;
            }
        }
        return null;
    }

    private void verifyNullAndThrowException(String fieldName, Object value){
        if(value == null){
            throw new CaseStudyFbException("Following field is null: "+fieldName+" make sure input is correct");
        }
    }
}
