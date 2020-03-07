package com.sapient.casestudy.response;

import lombok.Data;

@Data
public class StandingResponse {
    String country_id;
    String country_name;
    String league_id;
    String league_name;
    String team_id;
    String team_name;
    String overall_league_position;
}
