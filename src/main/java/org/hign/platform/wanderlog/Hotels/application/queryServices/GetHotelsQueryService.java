package org.hign.platform.wanderlog.Hotels.application.queryServices;

import org.hign.platform.wanderlog.Hotels.domain.model.aggregates.Hotel;
import org.hign.platform.wanderlog.Hotels.infrastructure.persistence.jpa.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetHotelsQueryService {

    @Autowired
    private HotelRepository hotelsRepository;

    public List<Hotel> getAllHotels() {
        return hotelsRepository.findAll();
    }

    public Hotel getHotelById(Integer id) {
        return hotelsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Hotel not found"));
    }
}
