package org.hign.platform.wanderlog.TravelAgencies.infrastructure.persistence.jpa.repositories;

import org.hign.platform.wanderlog.TravelAgencies.domain.model.aggregates.TravelAgencies;
import org.hign.platform.wanderlog.TravelAgencies.domain.model.valueobjects.UserAgencyId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TravelAgenciesRepository extends JpaRepository<TravelAgencies, Integer> {
    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM TravelAgencies c WHERE c.travelAgencyProfile.organizationName = :name")
    boolean existsByName(@Param("name") String name);

    Optional<TravelAgencies> findByUserId(UserAgencyId userId);

    //Optional<TravelAgencies> findByTravelAgencyId(Integer agencyId);
}
