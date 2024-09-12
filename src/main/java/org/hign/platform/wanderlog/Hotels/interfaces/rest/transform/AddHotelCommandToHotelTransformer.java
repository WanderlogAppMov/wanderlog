package org.hign.platform.wanderlog.Hotels.interfaces.rest.transform;

import org.hign.platform.wanderlog.Hotels.domain.model.aggregates.Hotel;
import org.hign.platform.wanderlog.Hotels.domain.model.commands.AddHotelCommand;
import org.hign.platform.wanderlog.Hotels.interfaces.rest.resources.HotelResponse;
import org.springframework.stereotype.Component;

@Component
public class AddHotelCommandToHotelTransformer {

    public Hotel transform(AddHotelCommand command) {
        Hotel hotel = new Hotel();
        hotel.setHotelName(command.getHotelName());
        hotel.setCountry(command.getCountry());
        hotel.setCity(command.getCity());
        hotel.setStars(command.getStars());
        hotel.setPricePerNight(command.getPricePerNight());
        return hotel;
    }
}
