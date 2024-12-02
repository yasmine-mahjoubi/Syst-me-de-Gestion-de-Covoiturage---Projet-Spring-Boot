package Entity;

import jakarta.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoIncrement
    private Long id;

    private Double rating;

    @Column(length = 500)
    private String comments;

    // Relations

    //table ride
    @ManyToOne
    @JoinColumn(name = "ride_id", nullable = false)
    private Ride ride;

    //table user pour l'evaluateur
    @ManyToOne
    @JoinColumn(name = "reviewer_id", nullable = false)
    private User reviewer;

    //table user pour l'evalué
    @ManyToOne
    @JoinColumn(name = "reviewee_id", nullable = false)
    private User reviewee;

    // Getters
    public Long getId() {
        return id;
    }

    public Double getRating() {
        return rating;
    }

    public String getComments() {
        return comments;
    }

    public Ride getRide() {
        return ride;
    }

    public User getReviewer() {
        return reviewer;
    }

    public User getReviewee() {
        return reviewee;
    }
    //Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setRide(Ride ride) {
        this.ride = ride;
    }

    public void setReviewer(User reviewer) {
        this.reviewer = reviewer;
    }

    public void setReviewee(User reviewee) {
        this.reviewee = reviewee;
    }
    // Constructors
    // toString(), equals(), hashCode()

}
