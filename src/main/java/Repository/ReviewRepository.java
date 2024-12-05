package Repository;

import Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    // Récupère tous les avis pour un trajet donné
    List<Review> findByRideId(Long rideId);
    //Optional<Review> findById(Long id);
    List<Review> findByReviewerId(Long reviewerId); // Avis donnés par un utilisateur
    List<Review> findByRevieweeId(Long revieweeId); // Avis reçus par un utilisateur
}
