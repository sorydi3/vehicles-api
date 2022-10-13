package com.udacity.vehicles.client.maps;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("${maps.service.name}") // maps.service.name is defined in application.properties
public interface FeingClientMap {
    @GetMapping("/maps/")
    Address getAddress(@RequestParam Double lat, @RequestParam Double lon);
}
