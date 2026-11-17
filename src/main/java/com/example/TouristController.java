package com.example;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/tourist")
public class TouristController {

    private final TouristService service;

    public TouristController(TouristService service) {
        this.service = service;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTourist(
            @PathVariable Long id,
            @RequestBody Tourist tourist) {

        try {
            Tourist updated =
                    service.updateTourist(id, tourist);

            return ResponseEntity.ok(updated);

        } catch (RuntimeException e) {

            return ResponseEntity.status(404)
                    .body("Tourist not found");
        }
    }
}