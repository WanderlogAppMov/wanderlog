package org.hign.platform.wanderlog.TravelPackages.application.commandServices;

import jakarta.persistence.*;
import org.hign.platform.wanderlog.TravelPackages.domain.model.aggregates.TravelPackages;
import org.hign.platform.wanderlog.TravelPackages.domain.model.commands.AddTravelPackageCommand;
import org.hign.platform.wanderlog.TravelPackages.infrastructure.persistence.jpa.repositories.TravelPackagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AddTravelPackageCommandService {

    @Autowired
    private TravelPackagesRepository travelPackagesRepository;

    public TravelPackages addTravelPackage(AddTravelPackageCommand command) {
        TravelPackages travelPackage = new TravelPackages();
        travelPackage.setDestination(command.getDestination());
        travelPackage.setTransportationDetails(command.getTransportationDetails());
        travelPackage.setAccommodationDetails(command.getAccommodationDetails());
        travelPackage.setActivitiesDetails(command.getActivitiesDetails());
        travelPackage.setPricePerStudent(command.getPricePerStudent());

        return travelPackagesRepository.save(travelPackage);
    }

    public TravelPackages updateTravelPackage(Integer id, AddTravelPackageCommand command) {
        TravelPackages travelPackage = travelPackagesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Travel package not found"));

        travelPackage.setDestination(command.getDestination());
        travelPackage.setTransportationDetails(command.getTransportationDetails());
        travelPackage.setAccommodationDetails(command.getAccommodationDetails());
        travelPackage.setActivitiesDetails(command.getActivitiesDetails());
        travelPackage.setPricePerStudent(command.getPricePerStudent());

        return travelPackagesRepository.save(travelPackage);
    }

    // Aquí agregamos el método para eliminar un paquete
    public void deleteTravelPackage(Integer id) {
        TravelPackages travelPackage = travelPackagesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Travel package not found"));
        travelPackagesRepository.delete(travelPackage);
    }
}