package org.hign.platform.wanderlog.Restaurants.domain.model.commands;

public class AddRestaurantCommand {

    private String restaurantName;
    private String country;
    private String city;
    private String cuisineType;
    private String priceRange;
    private Integer continentId; // Agregar el campo continentId

    // Constructor
    public AddRestaurantCommand(String restaurantName, String country, String city, String cuisineType, String priceRange, Integer continentId) {
        this.restaurantName = restaurantName;
        this.country = country;
        this.city = city;
        this.cuisineType = cuisineType;
        this.priceRange = priceRange;
        this.continentId = continentId;
    }

    // Getters y Setters
    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

    public Integer getContinentId() {
        return continentId;
    }

    public void setContinentId(Integer continentId) {
        this.continentId = continentId;
    }
}
