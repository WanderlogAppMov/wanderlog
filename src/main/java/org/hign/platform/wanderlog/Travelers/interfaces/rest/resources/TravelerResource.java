package org.hign.platform.wanderlog.Travelers.interfaces.rest.resources;

public record TravelerResource(
        Integer travelerId,
        String firstName,
        String lastName,
        String gender,
        String birthdate
) {
}
