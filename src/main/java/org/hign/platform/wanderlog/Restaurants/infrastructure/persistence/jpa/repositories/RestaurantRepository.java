package org.hign.platform.wanderlog.Restaurants.infrastructure.persistence.jpa.repositories;

import org.hign.platform.wanderlog.Restaurants.domain.model.aggregates.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    // Búsqueda por ciudad
    List<Restaurant> findByCity(String city);

    // Búsqueda por tipo de cocina
    List<Restaurant> findByCuisineType(String cuisineType);

    // Búsqueda por ID de continente
    List<Restaurant> findByContinent_ContinentID(Integer continentID);

    // Búsqueda por país
    List<Restaurant> findByCountry(String country);
}
