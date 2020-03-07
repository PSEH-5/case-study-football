package com.sapient.casestudy;

import com.sapient.casestudy.response.StandingResponse;
import com.sapient.casestudy.service.StandingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
//@TestPropertySource(properties = {"management.port=0"})
public class StandingsApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private StandingService standingService;

    @Autowired
    private TestRestTemplate testRestTemplate;


    @Test
    public void getTeamStandings() {
        StandingResponse response = standingService.getStandings("England", "Championship", "West Brom");
        assert (response != null);
    }

    @Test
    public void getTeamStandings_InvalidData() {
        try {
            standingService.getStandings("England123", "Championship12", "West Brom12");
            assert (false);
        } catch (Exception e) {
            assert (true);
        }
    }
}
