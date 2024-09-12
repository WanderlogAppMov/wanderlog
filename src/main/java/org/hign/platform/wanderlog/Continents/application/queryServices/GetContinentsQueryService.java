package org.hign.platform.wanderlog.Continents.application.queryServices;

import org.hign.platform.wanderlog.Continents.domain.model.aggregates.Continent;
import org.hign.platform.wanderlog.Continents.infrastructure.persistence.jpa.repositories.ContinentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetContinentsQueryService {

    @Autowired
    private ContinentRepository continentRepository;

    public List<Continent> getAllContinents() {
        return continentRepository.findAll();
    }
}
