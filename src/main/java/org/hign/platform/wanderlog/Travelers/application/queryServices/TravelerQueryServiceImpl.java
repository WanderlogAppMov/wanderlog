package org.hign.platform.wanderlog.Travelers.application.queryServices;

import org.hign.platform.wanderlog.Travelers.domain.model.aggregates.Travelers;
import org.hign.platform.wanderlog.Travelers.domain.model.valueobjects.UserId;
import org.hign.platform.wanderlog.Travelers.domain.services.TravelerQueryService;
import org.hign.platform.wanderlog.Travelers.infrastructure.persistence.jpa.repositories.TravelersRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TravelerQueryServiceImpl implements TravelerQueryService {

    private final TravelersRepository travelersRepository;

    public TravelerQueryServiceImpl(TravelersRepository travelersRepository) {
        this.travelersRepository = travelersRepository;
    }

    @Override
    public Optional<Travelers> findById(Integer id) {
        return travelersRepository.findById(id);
    }

    @Override
    public Optional<Travelers> findByUserId(Integer userId) {
        var id = new UserId(userId);
        return travelersRepository.findByUserId(id);
    }
}
