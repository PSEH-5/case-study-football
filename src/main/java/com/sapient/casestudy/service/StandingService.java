package com.sapient.casestudy.service;

import com.sapient.casestudy.connector.ApiConnector;
import com.sapient.casestudy.pojo.Country;
import com.sapient.casestudy.pojo.League;
import com.sapient.casestudy.pojo.Standing;
import com.sapient.casestudy.response.StandingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StandingService {

    @Autowired
    ApiConnector apiConnector;

    public StandingResponse getStandings(String countryName, String leagueName, String teamName) {
        StandingResponse standingResponse = new StandingResponse();

        List<Country> countries = apiConnector.getCountries();
        String countryId = getCountryIdByName(countries, countryName);

        standingResponse.setCountry_id(countryId);
        standingResponse.setCountry_name(countryName);

        List<League> leagues = apiConnector.getLeagues(countryId);
        String leagueId = getLeagueIdByName(leagues, leagueName);

        standingResponse.setLeague_id(leagueId);
        standingResponse.setLeague_name(leagueName);

        List<Standing> standings = apiConnector.getStandings(teamName);
        Standing standing = getStandingByTeamName(standings, teamName);

        standingResponse.setTeam_id(standing.getTeam_id());
        standingResponse.setTeam_name(standing.getTeam_name());
        standingResponse.setOverall_league_position(standing.getOverall_league_position());

        return standingResponse;
    }

    private String getCountryIdByName(List<Country> countries, String countryName) {
        String countryId = null;
        for (Country country : countries) {
            if (countryName.equalsIgnoreCase(country.getCountry_name())) {
                countryId = country.getCountry_id();
                break;
            }
        }
        return countryId;
    }

    private String getLeagueIdByName(List<League> leagues, String leagueName) {
        String leagueId = null;
        for (League league : leagues) {
            if (leagueName.equalsIgnoreCase(league.getLeague_name())) {
                leagueId = league.getLeague_id();
                break;
            }
        }
        return leagueId;
    }

    private Standing getStandingByTeamName(List<Standing> standings , String teamName){
        Standing standing = null;
        for (Standing s : standings) {
            if(teamName.equalsIgnoreCase(s.getTeam_name())){
                standing = s;
                break;
            }
        }
        return standing;
    }

}
