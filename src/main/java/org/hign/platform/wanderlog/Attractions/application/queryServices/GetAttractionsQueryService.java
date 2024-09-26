package org.hign.platform.wanderlog.Attractions.application.queryServices;

import org.hign.platform.wanderlog.Attractions.domain.model.aggregates.Attractions;
import org.hign.platform.wanderlog.Attractions.infrastructure.persistence.jpa.repositories.AttractionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAttractionsQueryService {

    @Autowired
    private AttractionsRepository attractionsRepository;

    public List<Attractions> getAllAttractions() {
        return attractionsRepository.findAll();
    }

    public Attractions getAttractionById(Integer id) {
        return attractionsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Attraction not found"));
    }

    public List<Attractions> getAttractionsByContinentId(Integer continentId) {
        return attractionsRepository.findByContinent_ContinentID(continentId);
    }

    public List<Attractions> getAttractionsByCity(String city) {
        return attractionsRepository.findByCity(city);
    }

    public List<Attractions> getAttractionsByCountry(String country) {
        return attractionsRepository.findByCountry(country);
    }
}
