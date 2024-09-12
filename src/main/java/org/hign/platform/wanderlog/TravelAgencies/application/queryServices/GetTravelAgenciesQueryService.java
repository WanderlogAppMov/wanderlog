package org.hign.platform.wanderlog.TravelAgencies.application.queryServices;

import org.hign.platform.wanderlog.TravelAgencies.domain.model.aggregates.TravelAgencies;
import org.hign.platform.wanderlog.TravelAgencies.infrastructure.persistence.jpa.repositories.TravelAgenciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetTravelAgenciesQueryService {

    @Autowired
    private TravelAgenciesRepository travelAgenciesRepository;

    public List<TravelAgencies> getAllAgencies() {
        return travelAgenciesRepository.findAll();
    }

    public TravelAgencies getAgencyById(Integer id) {
        return travelAgenciesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Agency not found"));
    }
}