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
        catFact();
        System.exit(0);
    }

    public static void catFact() {

        try {
            String url = "https://catfact.ninja/fact";
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String jSonPrice = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jSonPrice);

            //gets country name
            String catFact = root.findValue("fact").asText();

            //print vals
            System.out.println("cat fact: " + catFact);

        } catch (JsonProcessingException ex) {
            System.out.println("error in ravenPrice");
        }
    }

}
