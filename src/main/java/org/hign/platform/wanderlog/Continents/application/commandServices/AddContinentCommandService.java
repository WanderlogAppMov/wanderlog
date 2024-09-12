package org.hign.platform.wanderlog.Continents.application.commandServices;

import org.hign.platform.wanderlog.Continents.domain.model.aggregates.Continent;
import org.hign.platform.wanderlog.Continents.infrastructure.persistence.jpa.repositories.ContinentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddContinentCommandService {

    @Autowired
    private ContinentRepository continentRepository;

    public Continent addContinent(String continentName) {
        Continent continent = new Continent();
        continent.setContinentName(continentName);
        return continentRepository.save(continent);
    }
}
