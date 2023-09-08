package com.example.CSC340.hw2PRS;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Hw2PrsApplication {

    public static void main(String[] args) {
        SpringApplication.run(Hw2PrsApplication.class, args);
        ravenPrice();
        System.exit(0);
    }

    public static void ravenPrice() {

        try {
            String url = " https://restcountries.com/v3.1/all ";
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String jSonPrice = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jSonPrice);

            //gets country name
            String countryName = root.findValue("name").asText();

            //print vals
            System.out.println("Country: " + countryName);

        } catch (JsonProcessingException ex) {
            System.out.println("error in ravenPrice");
        }
    }

}
