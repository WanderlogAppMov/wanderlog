package org.hign.platform.wanderlog.Travelers.domain.model.aggregates;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name = "travelers")
public class Travelers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer travelerId;

    @Column(nullable = false, length = 100)
    @NotNull(message = "First name is mandatory")
    private String firstName;

    @Column(nullable = false, length = 100)
    @NotNull(message = "Last name is mandatory")
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false, length = 255)
    @NotNull(message = "Email is mandatory")
    private String email;

    @Column(nullable = false, length = 255)
    @NotNull(message = "Password hash is mandatory")
    private String passwordHash;

    @Temporal(TemporalType.DATE)
    @NotNull(message = "Birthdate is mandatory")
    private Date birthdate;

    @Column(length = 20)
    @NotNull(message = "Cellphone is mandatory")
    private String cellphone;

    @Column(length = 255)
    @NotNull(message = "Street address is mandatory")
    private String streetAddress;

    @Column(length = 100)
    @NotNull(message = "City is mandatory")
    private String city;

    @Column(length = 100)
    @NotNull(message = "Region is mandatory")
    private String region;

    @Column(length = 20)
    @NotNull(message = "Postal code is mandatory")
    private String postalCode;

    @Column(length = 100)
    @NotNull(message = "Country is mandatory")
    private String country;

    // Getters and Setters

    public Integer getTravelerId() {
        return travelerId;
    }

    public void setTravelerId(Integer travelerId) {
        this.travelerId = travelerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public enum Gender {
        MALE, FEMALE, OTHER
    }
}
