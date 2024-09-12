package org.hign.platform.wanderlog.Hotels.application.queryServices;

import org.hign.platform.wanderlog.Hotels.domain.model.aggregates.Hotel;
import org.hign.platform.wanderlog.Hotels.infrastructure.persistence.jpa.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetHotelsQueryService {

    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    // Obtener hoteles por ID de continente
    public List<Hotel> getHotelsByContinentId(Integer continentId) {
        return hotelRepository.findByContinentContinentID(continentId);
    }

    // Obtener hoteles por nombre de continente
    public List<Hotel> getHotelsByContinentName(String continentName) {
        return hotelRepository.findByContinentContinentName(continentName);
    }
}
