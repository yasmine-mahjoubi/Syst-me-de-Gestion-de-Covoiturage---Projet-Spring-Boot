package Controller;

import Entity.Review;
import Services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        return ResponseEntity.ok(reviewService.createReview(review));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Review>> getReviewById(@PathVariable Long id) {
        return ResponseEntity.ok(reviewService.getReviewById(id));
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        return ResponseEntity.ok(reviewService.getAllReviews());
    }

    @GetMapping("/ride/{rideId}")
    public ResponseEntity<List<Review>> getReviewsByRide(@PathVariable Long rideId) {
        return ResponseEntity.ok(reviewService.getReviewsByRide(rideId));
    }

    @GetMapping("/user/{revieweeId}")
    public ResponseEntity<List<Review>> getReviewsByUser(@PathVariable Long revieweeId) {
        return ResponseEntity.ok(reviewService.getReviewsByUserId(revieweeId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }
}
