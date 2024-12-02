package Entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String departure;
    private String destination;

    private LocalDate date;
    private LocalTime time;

    private Integer nb_place;
    private Double price;

    @Column(length = 500)
    private String comments;

    // Relations

    //table user
    @ManyToOne
    @JoinColumn(name = "driver_id", nullable = false)
    private User driver;

    @OneToMany(mappedBy = "ride", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    @OneToMany(mappedBy = "ride", cascade = CascadeType.ALL)
    private List<Review> reviews;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public Integer getNb_place() {
        return nb_place;
    }

    public Double getPrice() {
        return price;
    }

    public String getComments() {
        return comments;
    }

    public User getDriver() {
        return driver;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void setDriver(User driver) {
        this.driver = driver;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setNb_place(Integer nb_place) {
        this.nb_place = nb_place;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }
    // Constructors
    // toString(), equals(), hashCode()
}
