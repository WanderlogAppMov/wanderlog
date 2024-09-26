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

    // Obtener hoteles por ID de continente
    public List<Hotel> getHotelsByContinentId(Integer continentId) {
        return hotelsRepository.findByContinent_ContinentID(continentId);
    }

    public List<Hotel> getHotelsByCity(String city) {
        return hotelsRepository.findByCity(city);
    }

    public List<Hotel> getHotelsByCountry(String country) {
        return hotelsRepository.findByCountry(country);
    }
}
