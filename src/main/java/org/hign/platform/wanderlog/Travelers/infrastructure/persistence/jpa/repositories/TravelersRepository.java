package org.hign.platform.wanderlog.Travelers.infrastructure.persistence.jpa.repositories;

import org.hign.platform.wanderlog.Travelers.domain.model.aggregates.Travelers;
import org.hign.platform.wanderlog.Travelers.domain.model.valueobjects.UserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TravelersRepository extends JpaRepository<Travelers, Integer> {
    //boolean existsByEmail(String email);
    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Travelers c WHERE c.travelerProfile.firstName = :name")
    boolean existsByName(@Param("name") String name);

    Optional<Travelers> findByUserId(UserId userId);
}