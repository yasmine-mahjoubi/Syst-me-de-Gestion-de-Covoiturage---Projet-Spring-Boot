package Repository;

import Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByReviewerId(Long reviewerId); // Avis donnés par un utilisateur
    List<Review> findByRevieweeId(Long revieweeId); // Avis reçus par un utilisateur
}