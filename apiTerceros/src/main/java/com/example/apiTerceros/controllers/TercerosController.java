package com.example.apiTerceros.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/test")
public class TercerosController {

    @GetMapping("/{name}")
    public ResponseEntity<String> getCountry(@PathVariable String name){
        RestTemplate restTemplate= new RestTemplate();
        String country= restTemplate.getForObject("https://restcountries.com/v3.1/name/{name}",String.class);
        return ResponseEntity.ok(country);
    }
}
