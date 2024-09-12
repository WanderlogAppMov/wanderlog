package org.hign.platform.wanderlog.Hotels.infrastructure.persistence.jpa.repositories;

import org.hign.platform.wanderlog.Hotels.domain.model.aggregates.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
}