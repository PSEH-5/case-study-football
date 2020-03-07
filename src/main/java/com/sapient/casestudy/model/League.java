package com.sapient.casestudy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class League {
    String country_id;
    String country_name;
    String league_id;
    String league_name;
}
