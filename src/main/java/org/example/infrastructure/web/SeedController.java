package org.example.infrastructure.web;

import org.example.application.services.SeedService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seed")
public class SeedController {

    private final SeedService seedService;

    public SeedController(SeedService seedService) {
        this.seedService = seedService;
    }

    @GetMapping("/clients")
    public ResponseEntity<Void> seedClients() {
        seedService.seedClients();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/hotel-rooms")
    public ResponseEntity<Void> seedHotelRooms() {
        seedService.seedHotelRooms();
        return ResponseEntity.ok().build();
    }
}