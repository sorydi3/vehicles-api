package com.udacity.vehicles.client.prices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("${pricing.service.name}") // pricing.service.name is defined in application.properties
public interface FeingClientPricing {
    @GetMapping("services/price/")
    Price getPrice(@RequestParam Long vehicleId);
}
