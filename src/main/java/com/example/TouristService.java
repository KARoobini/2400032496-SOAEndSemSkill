package com.example;

import org.springframework.stereotype.Service;

@Service
public class TouristService {

    private final TouristRepository repository;

    public TouristService(TouristRepository repository) {
        this.repository = repository;
    }

    public Tourist updateTourist(Long id, Tourist updated) {

        Tourist tourist = repository.findById(id)
                .orElseThrow(() ->
                    new RuntimeException("Tourist not found"));

        tourist.setName(updated.getName());
        tourist.setDestination(updated.getDestination());
        tourist.setEmail(updated.getEmail());

        return repository.save(tourist);
    }
}