package org.hign.platform.wanderlog.TravelAgencies.application.queryServices;

import org.hign.platform.wanderlog.TravelAgencies.domain.model.aggregates.TravelAgencies;
import org.hign.platform.wanderlog.TravelAgencies.domain.model.valueobjects.UserAgencyId;
import org.hign.platform.wanderlog.TravelAgencies.domain.services.TravelAgencyQueryService;
import org.hign.platform.wanderlog.TravelAgencies.infrastructure.persistence.jpa.repositories.TravelAgenciesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TravelAgencyQueryServiceImpl implements TravelAgencyQueryService {

    private final TravelAgenciesRepository travelAgenciesRepository;

    public TravelAgencyQueryServiceImpl(TravelAgenciesRepository travelAgenciesRepository) {
        this.travelAgenciesRepository = travelAgenciesRepository;
    }

    @Override
    public Optional<TravelAgencies> findById(Integer id) {
        return travelAgenciesRepository.findById(id);
    }

    @Override
    public Optional<TravelAgencies> findByUserId(Integer userId) {
        var id = new UserAgencyId(userId);
        return travelAgenciesRepository.findByUserId(id);
    }

    @Override
    public Optional<List<TravelAgencies>> findAll() {
        return Optional.of(travelAgenciesRepository.findAll());
    }
}
