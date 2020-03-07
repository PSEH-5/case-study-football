//package com.sapient.casestudy;
//
//import com.sapient.casestudy.pojo.Country;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import java.util.List;
//
//public class Test {
//    public static void main(String args[]){
//        RestTemplate r = new RestTemplate();
//        UriComponentsBuilder builder = UriComponentsBuilder
//                .fromUriString("https://apiv2.apifootball.com/")
//                .queryParam("action", "get_countries")
//                .queryParam("APIkey", "9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978")
//                .queryParam("pageSize", "10");
//
//        List<Country> o = (List<Country>) r.getForEntity(builder.toUriString(), Object.class).getBody();
//    }
//}
