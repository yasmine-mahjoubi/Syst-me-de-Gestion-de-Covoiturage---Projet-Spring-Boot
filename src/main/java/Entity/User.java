package Entity;

import Entity.enums.Role;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role; // ENUM : CONDUCTEUR ou PASSAGER

    private Double rating;

    // Relations

    //table ride
    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
    private List<Ride> rides;

    //table reservation
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    //table review
    @OneToMany(mappedBy = "reviewer", cascade = CascadeType.ALL)
    private List<Review> givenReviews;

    @OneToMany(mappedBy = "reviewee", cascade = CascadeType.ALL)
    private List<Review> receivedReviews;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public Double getRating() {
        return rating;
    }

    public List<Ride> getRides() {
        return rides;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public List<Review> getGivenReviews() {
        return givenReviews;
    }

    public List<Review> getReceivedReviews() {
        return receivedReviews;
    }

    public void setReceivedReviews(List<Review> receivedReviews) {
        this.receivedReviews = receivedReviews;
    }

    public void setGivenReviews(List<Review> givenReviews) {
        this.givenReviews = givenReviews;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void setRides(List<Ride> rides) {
        this.rides = rides;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }
    // Constructors
    // toString(), equals(), hashCode()
}
