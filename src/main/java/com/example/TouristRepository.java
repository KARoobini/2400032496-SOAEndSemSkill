package com.example;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TouristRepository
        extends JpaRepository<Tourist, Long> {

}
