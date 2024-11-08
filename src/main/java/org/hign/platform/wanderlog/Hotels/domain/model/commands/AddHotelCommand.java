package org.hign.platform.wanderlog.Hotels.domain.model.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class AddHotelCommand {
    private final String hotelName;
    private final String country;
    private final String city;
    private final Integer stars;
    private final BigDecimal pricePerNight;
    private final Integer continentId; // Agregamos el ID del continente
    private final String imageUrl; // Agregamos la URL de la imagen
}
