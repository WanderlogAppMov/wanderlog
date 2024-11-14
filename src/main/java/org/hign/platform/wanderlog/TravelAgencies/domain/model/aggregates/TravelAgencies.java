package org.hign.platform.wanderlog.TravelAgencies.domain.model.aggregates;

import jakarta.persistence.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hign.platform.wanderlog.TravelAgencies.domain.model.commands.CreateTravelAgencyCommand;
import org.hign.platform.wanderlog.TravelAgencies.domain.model.valueobjects.TravelAgencyProfile;
import org.hign.platform.wanderlog.TravelAgencies.domain.model.valueobjects.UserAgencyId;


//@Table(name = "travelagencies")
@Entity
@Getter
@Setter
public class TravelAgencies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer agencyId;

    @Embedded
    private TravelAgencyProfile travelAgencyProfile;

    @Embedded
    private UserAgencyId userId;

    public TravelAgencies(CreateTravelAgencyCommand command, UserAgencyId userId){
        this.travelAgencyProfile = new TravelAgencyProfile(command.organizationName(), command.repreFirstName(), command.repreLastName());
        this.userId = userId;
    }

    public TravelAgencies(){
        this.travelAgencyProfile = new TravelAgencyProfile("", "", "");
    }

    public void update(TravelAgencyProfile travelAgencyProfile){
        this.travelAgencyProfile = travelAgencyProfile;
    }

    /*
    @Column(nullable = false, length = 255)
    @NotNull(message = "Organization name is mandatory")
    private String organizationName;

    @Column(nullable = false, length = 255)
    @NotNull(message = "Representative's first name is mandatory")
    private String repreFirstName;

    @Column(nullable = false, length = 255)
    @NotNull(message = "Representative's last name is mandatory")
    private String repreLastName;

    @Column(nullable = false, length = 255)
    @Email(message = "Email should be valid")
    private String contactEmail;

    @Column(nullable = false, length = 255)
    private String password;

    // Getters and Setters

    public Integer getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(Integer agencyId) {
        this.agencyId = agencyId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getRepreFirstName() {
        return repreFirstName;
    }

    public void setRepreFirstName(String repreFirstName) {
        this.repreFirstName = repreFirstName;
    }

    public String getRepreLastName() {
        return repreLastName;
    }

    public void setRepreLastName(String repreLastName) {
        this.repreLastName = repreLastName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }*/
}