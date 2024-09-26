package org.hign.platform.wanderlog.Restaurants.application.queryServices;

import org.hign.platform.wanderlog.Restaurants.domain.model.aggregates.Restaurant;
import org.hign.platform.wanderlog.Restaurants.infrastructure.persistence.jpa.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetRestaurantsQueryService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public List<Restaurant> getRestaurantsByCity(String city) {
        return restaurantRepository.findByCity(city);
    }

    public List<Restaurant> getRestaurantsByCuisineType(String cuisineType) {
        return restaurantRepository.findByCuisineType(cuisineType);
    }

    public List<Restaurant> getRestaurantsByContinentId(Integer continentId) {
        return restaurantRepository.findByContinent_ContinentID(continentId);
    }

    public List<Restaurant> getRestaurantsByCountry(String country) {
        return restaurantRepository.findByCountry(country);
    }
}
