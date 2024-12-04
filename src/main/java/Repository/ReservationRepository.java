package Repository;

import Entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByUserId(Long userId); // Les réservations d’un utilisateur
    List<Reservation> findByRideId(Long rideId); // Les réservations pour un trajet spécifique
}
