package org.hign.platform.wanderlog.Travelers.application.queryServices;

import org.hign.platform.wanderlog.Travelers.domain.model.aggregates.Travelers;
import org.hign.platform.wanderlog.Travelers.infrastructure.persistence.jpa.repositories.TravelersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetTravelersQueryService {

    @Autowired
    private TravelersRepository travelersRepository;

    public List<Travelers> getAllTravelers() {
        return travelersRepository.findAll();
    }

    public Travelers getTravelerById(Integer travelerId) {
        return travelersRepository.findById(travelerId)
                .orElseThrow(() -> new IllegalArgumentException("Traveler not found"));
    }
}
