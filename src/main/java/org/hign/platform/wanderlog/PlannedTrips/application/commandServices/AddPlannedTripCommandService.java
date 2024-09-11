package org.hign.platform.wanderlog.PlannedTrips.application.commandServices;

import org.hign.platform.wanderlog.PlannedTrips.domain.model.aggregates.PlannedTrips;
import org.hign.platform.wanderlog.PlannedTrips.domain.model.commands.AddPlannedTripCommand;
import org.hign.platform.wanderlog.PlannedTrips.infrastructure.persistence.jpa.repositories.PlannedTripsRepository;
import org.hign.platform.wanderlog.TravelPackages.infrastructure.persistence.jpa.repositories.TravelPackagesRepository;
import org.hign.platform.wanderlog.Travelers.infrastructure.persistence.jpa.repositories.TravelersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddPlannedTripCommandService {

    @Autowired
    private PlannedTripsRepository plannedTripsRepository;

    @Autowired
    private TravelersRepository travelersRepository;

    @Autowired
    private TravelPackagesRepository travelPackagesRepository;

    // Método para agregar un PlannedTrip
    public PlannedTrips addPlannedTrip(AddPlannedTripCommand command) {
        PlannedTrips plannedTrip = new PlannedTrips();
        plannedTrip.setTraveler(travelersRepository.findById(command.getTravelerId())
                .orElseThrow(() -> new IllegalArgumentException("Traveler not found")));
        plannedTrip.setTravelPackage(travelPackagesRepository.findById(command.getTravelPackageId())
                .orElseThrow(() -> new IllegalArgumentException("Travel package not found")));
        plannedTrip.setNumberOfStudents(command.getNumberOfStudents());
        plannedTrip.setTentativeDate(command.getTentativeDate());
        plannedTrip.setBudget(command.getBudget());
        plannedTrip.setStatus(PlannedTrips.Status.valueOf(command.getStatus()));

        return plannedTripsRepository.save(plannedTrip);
    }

    // Método para actualizar un PlannedTrip
    public PlannedTrips updatePlannedTrip(Integer id, AddPlannedTripCommand command) {
        PlannedTrips plannedTrip = plannedTripsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Planned trip not found"));

        plannedTrip.setTraveler(travelersRepository.findById(command.getTravelerId())
                .orElseThrow(() -> new IllegalArgumentException("Traveler not found")));
        plannedTrip.setTravelPackage(travelPackagesRepository.findById(command.getTravelPackageId())
                .orElseThrow(() -> new IllegalArgumentException("Travel package not found")));
        plannedTrip.setNumberOfStudents(command.getNumberOfStudents());
        plannedTrip.setTentativeDate(command.getTentativeDate());
        plannedTrip.setBudget(command.getBudget());
        plannedTrip.setStatus(PlannedTrips.Status.valueOf(command.getStatus()));

        return plannedTripsRepository.save(plannedTrip);
    }

    // Método para eliminar un PlannedTrip
    public void deletePlannedTrip(Integer id) {
        PlannedTrips plannedTrip = plannedTripsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Planned trip not found"));
        plannedTripsRepository.delete(plannedTrip);
    }
}