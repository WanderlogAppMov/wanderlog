package org.hign.platform.wanderlog.Attractions.domain.model.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class AddAttractionCommand {
    private final String attractionName;
    private final String country;
    private final String city;
    private final BigDecimal ticketPrice;
    private final Integer continentId;
}
