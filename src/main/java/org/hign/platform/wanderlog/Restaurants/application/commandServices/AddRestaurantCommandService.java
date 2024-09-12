package org.hign.platform.wanderlog.Restaurants.application.commandServices;

import org.hign.platform.wanderlog.Restaurants.domain.model.aggregates.Restaurant;
import org.hign.platform.wanderlog.Restaurants.infrastructure.persistence.jpa.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddRestaurantCommandService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public Restaurant addRestaurant(String restaurantName, String country, String city, String cuisineType, String priceRange) {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantName(restaurantName);
        restaurant.setCountry(country);
        restaurant.setCity(city);
        restaurant.setCuisineType(cuisineType);
        restaurant.setPriceRange(priceRange);
        return restaurantRepository.save(restaurant);
    }

    // Método para actualizar un restaurante
    public Restaurant updateRestaurant(Integer restaurantId, String restaurantName, String country, String city, String cuisineType, String priceRange) {
        return restaurantRepository.findById(restaurantId).map(restaurant -> {
            restaurant.setRestaurantName(restaurantName);
            restaurant.setCountry(country);
            restaurant.setCity(city);
            restaurant.setCuisineType(cuisineType);
            restaurant.setPriceRange(priceRange);
            return restaurantRepository.save(restaurant);
        }).orElseThrow(() -> new IllegalArgumentException("Restaurant not found"));
    }

    // Método para eliminar un restaurante
    public void deleteRestaurant(Integer restaurantId) {
        if (restaurantRepository.existsById(restaurantId)) {
            restaurantRepository.deleteById(restaurantId);
        } else {
            throw new IllegalArgumentException("Restaurant not found");
        }
    }
}