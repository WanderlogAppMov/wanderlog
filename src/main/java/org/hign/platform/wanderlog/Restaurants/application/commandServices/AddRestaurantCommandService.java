package org.hign.platform.wanderlog.Restaurants.application.commandServices;

import org.hign.platform.wanderlog.Continents.infrastructure.persistence.jpa.repositories.ContinentRepository;
import org.hign.platform.wanderlog.Restaurants.domain.model.aggregates.Restaurant;
import org.hign.platform.wanderlog.Restaurants.infrastructure.persistence.jpa.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddRestaurantCommandService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private ContinentRepository continentRepository;

    public Restaurant addRestaurant(String restaurantName, String country, String city, String cuisineType, String priceRange, Integer continentId) {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantName(restaurantName);
        restaurant.setCountry(country);
        restaurant.setCity(city);
        restaurant.setCuisineType(cuisineType);
        restaurant.setPriceRange(priceRange);

        // Asignar el continente
        restaurant.setContinent(continentRepository.findById(continentId)
                .orElseThrow(() -> new IllegalArgumentException("Continent not found")));

        return restaurantRepository.save(restaurant);
    }

    public Restaurant updateRestaurant(Integer restaurantId, String restaurantName, String country, String city, String cuisineType, String priceRange, Integer continentId) {
        return restaurantRepository.findById(restaurantId).map(restaurant -> {
            restaurant.setRestaurantName(restaurantName);
            restaurant.setCountry(country);
            restaurant.setCity(city);
            restaurant.setCuisineType(cuisineType);
            restaurant.setPriceRange(priceRange);

            // Asignar el continente en la actualización
            restaurant.setContinent(continentRepository.findById(continentId)
                    .orElseThrow(() -> new IllegalArgumentException("Continent not found")));

            return restaurantRepository.save(restaurant);
        }).orElseThrow(() -> new IllegalArgumentException("Restaurant not found"));
    }

    public void deleteRestaurant(Integer restaurantId) {
        if (restaurantRepository.existsById(restaurantId)) {
            restaurantRepository.deleteById(restaurantId);
        } else {
            throw new IllegalArgumentException("Restaurant not found");
        }
    }
}
