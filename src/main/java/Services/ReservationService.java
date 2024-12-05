package Services;

import Entity.Reservation;
import Entity.enums.ReservationStatus;
import Repository.ReservationRepository;
import org.springframework.stereotype.Service;
import Exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).orElseThrow(() -> new RuntimeException("Reservation not found"));
    }

    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public void cancelReservation(Long id) {
        Reservation reservation = getReservationById(id);
        reservation.setStatus(ReservationStatus.CANCELED);
        reservationRepository.save(reservation);
    }

    public List<Reservation> getReservationsByUser(Long userId) {
        return reservationRepository.findByUserId(userId);
    }

    public Reservation updateReservation(Long reservationId, Reservation updatedReservation) {
        // Recherche la réservation par son ID
        Optional<Reservation> existingReservation = reservationRepository.findById(reservationId);

        if(existingReservation.isPresent()) {
            Reservation reservation = existingReservation.get();

            // Mettre à jour les champs nécessaires
            reservation.setNb_place_reserve(updatedReservation.getNb_place_reserve());
            reservation.setStatus(updatedReservation.getStatus());

            // Sauvegarde la réservation mise à jour
            return reservationRepository.save(reservation);
        } else {
            throw new ResourceNotFoundException("Reservation not found with ID: " + reservationId);
        }
    }

    public void deleteReservation(Long reservationId) {
        Optional<Reservation> existingReservation = reservationRepository.findById(reservationId);

        if(existingReservation.isPresent()) {
            reservationRepository.delete(existingReservation.get());  // Supprime la réservation
        } else {
            throw new ResourceNotFoundException("Reservation not found with ID: " + reservationId);
        }
    }

}

