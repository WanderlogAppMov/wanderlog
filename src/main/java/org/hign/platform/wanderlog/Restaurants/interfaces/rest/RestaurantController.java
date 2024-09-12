package org.hign.platform.wanderlog.Restaurants.interfaces.rest;

import org.hign.platform.wanderlog.Restaurants.application.commandServices.AddRestaurantCommandService;
import org.hign.platform.wanderlog.Restaurants.application.queryServices.GetRestaurantsQueryService;
import org.hign.platform.wanderlog.Restaurants.domain.model.aggregates.Restaurant;
import org.hign.platform.wanderlog.Restaurants.domain.model.commands.AddRestaurantCommand;
import org.hign.platform.wanderlog.Restaurants.interfaces.rest.resources.RestaurantResponse;
import org.hign.platform.wanderlog.Restaurants.interfaces.rest.transform.RestaurantResponseTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @Autowired
    private AddRestaurantCommandService addRestaurantCommandService;

    @Autowired
    private GetRestaurantsQueryService getRestaurantsQueryService;

    @GetMapping
    public List<RestaurantResponse> getRestaurants() {
        List<Restaurant> restaurants = getRestaurantsQueryService.getAllRestaurants();
        return restaurants.stream().map(RestaurantResponseTransformer::transform).collect(Collectors.toList());
    }

    // Obtener restaurantes por ciudad
    @GetMapping("/city/{city}")
    public List<RestaurantResponse> getRestaurantsByCity(@PathVariable String city) {
        List<Restaurant> restaurants = getRestaurantsQueryService.getRestaurantsByCity(city);
        return restaurants.stream().map(RestaurantResponseTransformer::transform).collect(Collectors.toList());
    }

    // Obtener restaurantes por tipo de cocina
    @GetMapping("/cuisine/{cuisineType}")
    public List<RestaurantResponse> getRestaurantsByCuisineType(@PathVariable String cuisineType) {
        List<Restaurant> restaurants = getRestaurantsQueryService.getRestaurantsByCuisineType(cuisineType);
        return restaurants.stream().map(RestaurantResponseTransformer::transform).collect(Collectors.toList());
    }

    // POST para añadir un restaurante
    @PostMapping
    public RestaurantResponse addRestaurant(@RequestBody AddRestaurantCommand command) {
        Restaurant restaurant = addRestaurantCommandService.addRestaurant(command.getRestaurantName(), command.getCountry(), command.getCity(), command.getCuisineType(), command.getPriceRange());
        return RestaurantResponseTransformer.transform(restaurant);
    }

    // PUT para actualizar un restaurante
    @PutMapping("/{restaurantId}")
    public RestaurantResponse updateRestaurant(@PathVariable Integer restaurantId, @RequestBody AddRestaurantCommand command) {
        Restaurant restaurant = addRestaurantCommandService.updateRestaurant(restaurantId, command.getRestaurantName(), command.getCountry(), command.getCity(), command.getCuisineType(), command.getPriceRange());
        return RestaurantResponseTransformer.transform(restaurant);
    }

    // DELETE para eliminar un restaurante
    @DeleteMapping("/{restaurantId}")
    public String deleteRestaurant(@PathVariable Integer restaurantId) {
        addRestaurantCommandService.deleteRestaurant(restaurantId);
        return "Restaurant deleted successfully";
    }
}