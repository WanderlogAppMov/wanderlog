package org.hign.platform.wanderlog.Travelers.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor
public class TravelerProfile {
    private String firstName;
    private String lastName;
    private String gender;
    private String birthdate;

    public TravelerProfile(String firstName, String lastName, String gender, String birthdate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthdate = birthdate;
    }
}
