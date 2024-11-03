package org.hign.platform.wanderlog.Hotels.application.commandServices;

import org.hign.platform.wanderlog.Continents.infrastructure.persistence.jpa.repositories.ContinentRepository;
import org.hign.platform.wanderlog.Hotels.domain.model.aggregates.Hotel;
import org.hign.platform.wanderlog.Hotels.domain.model.commands.AddHotelCommand;
import org.hign.platform.wanderlog.Hotels.infrastructure.persistence.jpa.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddHotelCommandService {

    @Autowired
    private HotelRepository hotelsRepository;

    @Autowired
    private ContinentRepository continentRepository; // Agregamos el repositorio de Continents

    public Hotel addHotel(AddHotelCommand command) {
        Hotel hotel = new Hotel();
        hotel.setHotelName(command.getHotelName());
        hotel.setCountry(command.getCountry());
        hotel.setCity(command.getCity());
        hotel.setStars(command.getStars());
        hotel.setPricePerNight(command.getPricePerNight());

        // Asignar continente usando el ID proporcionado
        hotel.setContinent(continentRepository.findById(command.getContinentId())
                .orElseThrow(() -> new IllegalArgumentException("Continent not found")));

        // Asignar la URL de la imagen
        hotel.setImageUrl(command.getImageUrl());

        return hotelsRepository.save(hotel);
    }

    public Hotel updateHotel(Integer id, AddHotelCommand command) {
        Hotel hotel = hotelsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Hotel not found"));

        hotel.setHotelName(command.getHotelName());
        hotel.setCountry(command.getCountry());
        hotel.setCity(command.getCity());
        hotel.setStars(command.getStars());
        hotel.setPricePerNight(command.getPricePerNight());

        // Asignar continente usando el ID proporcionado
        hotel.setContinent(continentRepository.findById(command.getContinentId())
                .orElseThrow(() -> new IllegalArgumentException("Continent not found")));

        // Asignar la URL de la imagen
        hotel.setImageUrl(command.getImageUrl());

        return hotelsRepository.save(hotel);
    }

    public void deleteHotel(Integer id) {
        Hotel hotel = hotelsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Hotel not found"));
        hotelsRepository.delete(hotel);
    }
}
