package org.hign.platform.wanderlog.TravelPackages.application.queryServices;

import jakarta.persistence.*;
import org.hign.platform.wanderlog.TravelPackages.domain.model.aggregates.TravelPackages;
import org.hign.platform.wanderlog.TravelPackages.infrastructure.persistence.jpa.repositories.TravelPackagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetTravelPackagesQueryService {

    @Autowired
    private TravelPackagesRepository travelPackagesRepository;

    public List<TravelPackages> getAllTravelPackages() {
        return travelPackagesRepository.findAll();
    }

    public TravelPackages getTravelPackageById(Integer id) {
        return travelPackagesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Travel package not found"));
    }
}
