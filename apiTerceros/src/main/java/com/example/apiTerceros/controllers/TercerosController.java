package com.example.apiTerceros.controllers;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.http.HttpResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/test")
public class TercerosController {

    @GetMapping("/{name}")
    public ResponseEntity<String> getCountry(@PathVariable String name){
        RestTemplate restTemplate= new RestTemplate();
        String country= restTemplate.getForObject("https://restcountries.com/v3.1/name/"+name,String.class);
        return ResponseEntity.ok(country);
    }

    @GetMapping("/unirest/{name}")
    public ResponseEntity<String> getCountry2(@PathVariable String name) throws UnirestException {
        String response=null;

        response=Unirest.get("https://restcountries.com/v3.1/name/"+name).asString().toString();
        return ResponseEntity.ok();
    }
}
