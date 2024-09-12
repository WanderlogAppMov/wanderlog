package org.hign.platform.wanderlog.Restaurants.interfaces.rest.transform;

import org.hign.platform.wanderlog.Restaurants.domain.model.aggregates.Restaurant;
import org.hign.platform.wanderlog.Restaurants.interfaces.rest.resources.RestaurantResponse;

public class RestaurantResponseTransformer {

    public static RestaurantResponse transform(Restaurant restaurant) {
        RestaurantResponse response = new RestaurantResponse();
        response.setRestaurantId(restaurant.getRestaurantId());
        response.setRestaurantName(restaurant.getRestaurantName());
        response.setCountry(restaurant.getCountry());
        response.setCity(restaurant.getCity());
        response.setCuisineType(restaurant.getCuisineType());
        response.setPriceRange(restaurant.getPriceRange());
        return response;
    }
}
