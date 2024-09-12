package org.hign.platform.wanderlog.Hotels.application.commandServices;

import org.hign.platform.wanderlog.Continents.domain.model.aggregates.Continent;
import org.hign.platform.wanderlog.Hotels.domain.model.aggregates.Hotel;
import org.hign.platform.wanderlog.Hotels.infrastructure.persistence.jpa.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class AddHotelCommandService {

    @Autowired
    private HotelRepository hotelRepository;

    public Hotel addHotel(String hotelName, String country, String city, int stars, BigDecimal pricePerNight, Continent continent) {
        Hotel hotel = new Hotel();
        hotel.setHotelName(hotelName);
        hotel.setCountry(country);
        hotel.setCity(city);
        hotel.setStars(stars);
        hotel.setPricePerNight(pricePerNight);
        hotel.setContinent(continent);
        return hotelRepository.save(hotel);
    }

    // Método para actualizar un hotel
    public Hotel updateHotel(Integer hotelId, String hotelName, String country, String city, int stars, BigDecimal pricePerNight, Continent continent) {
        Optional<Hotel> optionalHotel = hotelRepository.findById(hotelId);
        if (optionalHotel.isPresent()) {
            Hotel hotel = optionalHotel.get();
            hotel.setHotelName(hotelName);
            hotel.setCountry(country);
            hotel.setCity(city);
            hotel.setStars(stars);
            hotel.setPricePerNight(pricePerNight);
            hotel.setContinent(continent);
            return hotelRepository.save(hotel);
        } else {
            throw new IllegalArgumentException("Hotel not found");
        }
    }

    // Método para eliminar un hotel
    public void deleteHotel(Integer hotelId) {
        if (hotelRepository.existsById(hotelId)) {
            hotelRepository.deleteById(hotelId);
        } else {
            throw new IllegalArgumentException("Hotel not found");
        }
    }
}