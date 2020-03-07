package com.sapient.casestudy.connector;

import com.sapient.casestudy.pojo.Country;
import com.sapient.casestudy.pojo.League;
import com.sapient.casestudy.pojo.Standing;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Component
public class ApiConnector {

    @Value("${sapient.casestudy.game.baseurl}")
    private String apibaseUrl;

    @Value("${sapient.casestudy.game.apikey}")
    private String apiKey;

    RestTemplate restTemplate = new RestTemplate();

    public List getCountries() {
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(apibaseUrl)
                .queryParam("action", "get_countries")
                .queryParam("APIkey", apiKey);

        return (List) restTemplate.getForEntity(builder.toUriString(), Object.class).getBody();
    }

    public List getLeagues(String countryId) {
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(apibaseUrl)
                .queryParam("action", "get_leagues")
                .queryParam("country_id", countryId)
                .queryParam("APIkey", apiKey);

        return (List) restTemplate.getForEntity(builder.toUriString(), Object.class).getBody();
    }

    public List getStandings(String leagueId) {
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(apibaseUrl)
                .queryParam("action", "get_standings")
                .queryParam("league_id", leagueId)
                .queryParam("APIkey", apiKey);

        return (List) restTemplate.getForEntity(builder.toUriString(), Object.class).getBody();
    }

}
