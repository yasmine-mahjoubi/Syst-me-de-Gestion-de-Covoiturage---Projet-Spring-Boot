package Services;

import Entity.Ride;
import Repository.RideRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.List;

@Service
public class RideService {

    private final RideRepository rideRepository;

    public RideService(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }

    public List<Ride> getAllRides() {
        return rideRepository.findAll();
    }

    public Ride getRideById(Long id) {
        return rideRepository.findById(id).orElseThrow(() -> new RuntimeException("Ride not found"));
    }

    public Ride createRide(Ride ride) {
        return rideRepository.save(ride);
    }

    public Ride updateRide(Long id, Ride ride) {
        Ride existingRide = getRideById(id);
        existingRide.setDeparture(ride.getDeparture());
        existingRide.setDestination(ride.getDestination());
        existingRide.setDate(ride.getDate());
        existingRide.setTime(ride.getTime());
        existingRide.setNb_place(ride.getNb_place());
        existingRide.setPrice(ride.getPrice());
        return rideRepository.save(existingRide);
    }

    public void deleteRide(Long id) {
        rideRepository.deleteById(id);
    }

    //méthode de recherche de trajet
    public List<Ride> searchRides(String departure, String destination, LocalDate date, Double maxPrice) {
        return rideRepository.findRides(departure, destination, date, maxPrice);
    }

    public Ride saveRide(Ride ride) {
        // Validation des données
        if (ride.getNb_place() <= 0) {
            throw new IllegalArgumentException("Le nombre de places disponibles doit être supérieur à 0.");
        }
        if (ride.getDate().isBefore(ChronoLocalDate.from(LocalDateTime.now()))) {
            throw new IllegalArgumentException("La date de départ ne peut pas être dans le passé.");
        }
        return rideRepository.save(ride);
    }
}

