package Services;

import Entity.Ride;
import Repository.RideRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

    public List<Ride> findAvailableRides(String departure, String destination) {
        return rideRepository.findByDepartureAndDestination(departure, destination);
    }

    public Ride saveRide(Ride ride) {
        return rideRepository.save(ride);
    }
}

