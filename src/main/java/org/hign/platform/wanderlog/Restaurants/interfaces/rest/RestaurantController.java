package org.hign.platform.wanderlog.Restaurants.interfaces.rest;

import org.hign.platform.wanderlog.Restaurants.application.commandServices.AddRestaurantCommandService;
import org.hign.platform.wanderlog.Restaurants.application.queryServices.GetRestaurantsQueryService;
import org.hign.platform.wanderlog.Restaurants.domain.model.aggregates.Restaurant;
import org.hign.platform.wanderlog.Restaurants.domain.model.commands.AddRestaurantCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @Autowired
    private AddRestaurantCommandService addRestaurantCommandService;

    @Autowired
    private GetRestaurantsQueryService getRestaurantsQueryService;

    @GetMapping
    public List<Restaurant> getRestaurants() {
        return getRestaurantsQueryService.getAllRestaurants();
    }

    // Obtener restaurantes por ciudad
    @GetMapping("/city/{city}")
    public List<Restaurant> getRestaurantsByCity(@PathVariable String city) {
        return getRestaurantsQueryService.getRestaurantsByCity(city);
    }

    // Obtener restaurantes por tipo de cocina
    @GetMapping("/cuisine/{cuisineType}")
    public List<Restaurant> getRestaurantsByCuisineType(@PathVariable String cuisineType) {
        return getRestaurantsQueryService.getRestaurantsByCuisineType(cuisineType);
    }

    // Obtener restaurantes por continentId
    @GetMapping("/continent/{continentId}")
    public List<Restaurant> getRestaurantsByContinentId(@PathVariable Integer continentId) {
        return getRestaurantsQueryService.getRestaurantsByContinentId(continentId);
    }

    // POST para añadir un restaurante
    @PostMapping
    public Restaurant addRestaurant(@RequestBody AddRestaurantCommand command) {
        return addRestaurantCommandService.addRestaurant(
                command.getRestaurantName(),
                command.getCountry(),
                command.getCity(),
                command.getCuisineType(),
                command.getPriceRange(),
                command.getContinentId(), // Asegurarse de pasar continentId
                command.getImageUrl()  // Asegurarse de pasar imageUrl
        );
    }

    // PUT para actualizar un restaurante
    @PutMapping("/{restaurantId}")
    public Restaurant updateRestaurant(@PathVariable Integer restaurantId, @RequestBody AddRestaurantCommand command) {
        return addRestaurantCommandService.updateRestaurant(
                restaurantId,
                command.getRestaurantName(),
                command.getCountry(),
                command.getCity(),
                command.getCuisineType(),
                command.getPriceRange(),
                command.getContinentId(),  // Asegurarse de pasar continentId
                command.getImageUrl()  // Asegurarse de pasar imageUrl
        );
    }

    // DELETE para eliminar un restaurante
    @DeleteMapping("/{restaurantId}")
    public String deleteRestaurant(@PathVariable Integer restaurantId) {
        addRestaurantCommandService.deleteRestaurant(restaurantId);
        return "Restaurant deleted successfully";
    }

    // Nuevo endpoint para buscar restaurantes por país
    @GetMapping("/country/{country}")
    public List<Restaurant> getRestaurantsByCountry(@PathVariable String country) {
        return getRestaurantsQueryService.getRestaurantsByCountry(country);
    }
}
