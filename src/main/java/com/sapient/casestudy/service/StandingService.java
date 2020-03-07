package com.sapient.casestudy.service;

import com.sapient.casestudy.connector.ApiConnector;
import com.sapient.casestudy.response.StandingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StandingService {

    @Autowired
    ApiConnector apiConnector;

    public StandingResponse getStandings(String countryName, String leagueName, String teamName) {
        StandingResponse standingResponse = new StandingResponse();

        List<Map> countries = apiConnector.getCountries();
        String countryId = getCountryIdByName(countries, countryName);

        standingResponse.setCountry_id(countryId);
        standingResponse.setCountry_name(countryName);

        List<Map> leagues = apiConnector.getLeagues(countryId);
        String leagueId = getLeagueIdByName(leagues, leagueName);

        standingResponse.setLeague_id(leagueId);
        standingResponse.setLeague_name(leagueName);

        List<Map> standings = apiConnector.getStandings(teamName);
        Map<String, String> standing = getStandingByTeamName(standings, teamName);

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
}
