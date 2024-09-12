package org.hign.platform.wanderlog.Hotels.domain.model.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hign.platform.wanderlog.Continents.domain.model.aggregates.Continent;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class AddHotelCommand {
    private final String hotelName;
    private final String country;
    private final String city;
    private final Integer stars;
    private final BigDecimal pricePerNight;
}
