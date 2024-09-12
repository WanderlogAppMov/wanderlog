package org.hign.platform.wanderlog.Hotels.interfaces.rest.transform;

import org.hign.platform.wanderlog.Hotels.domain.model.aggregates.Hotel;
import org.hign.platform.wanderlog.Hotels.interfaces.rest.resources.HotelResponse;

public class HotelResponseTransformer {

    public static HotelResponse transform(Hotel hotel) {
        HotelResponse response = new HotelResponse();
        response.setHotelId(hotel.getHotelId());
        response.setHotelName(hotel.getHotelName());
        response.setCountry(hotel.getCountry());
        response.setCity(hotel.getCity());
        response.setStars(hotel.getStars());
        response.setPricePerNight(hotel.getPricePerNight());
        return response;
    }
}
