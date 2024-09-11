package org.hign.platform.wanderlog.PlannedTrips.application.queryServices;

import org.hign.platform.wanderlog.PlannedTrips.domain.model.aggregates.PlannedTrips;
import org.hign.platform.wanderlog.PlannedTrips.infrastructure.persistence.jpa.repositories.PlannedTripsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPlannedTripsQueryService {

    @Autowired
    private PlannedTripsRepository plannedTripsRepository;

    public List<PlannedTrips> getAllPlannedTrips() {
        return plannedTripsRepository.findAll();
    }

    public PlannedTrips getPlannedTripById(Integer id) {
        return plannedTripsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Planned trip not found"));
    }
}
