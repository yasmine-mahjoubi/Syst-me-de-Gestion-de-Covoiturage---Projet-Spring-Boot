package Entity;

import Entity.enums.ReservationStatus;
import jakarta.persistence.*;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idReserv;
    private String statut;
    private Integer nb_place_reserve;

    @Enumerated(EnumType.STRING)
    private ReservationStatus status; // ENUM : PENDING, CONFIRMED, CANCELED

    // Relations
    @ManyToOne
    @JoinColumn(name = "ride_id", nullable = false)
    private Ride ride;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Getters and Setters

    public long getIdReserv() {
        return idReserv;
    }

    public void setIdReserv(long idReserv) {
        this.idReserv = idReserv;
    }

    public String getStatut() {
        return statut;
    }

    public Integer getNb_place_reserve() {
        return nb_place_reserve;
    }

    public void setNb_place_reserve(Integer nb_place_reserve) {
        this.nb_place_reserve = nb_place_reserve;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Ride getRide() {
        return ride;
    }

    public void setRide(Ride ride) {
        this.ride = ride;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    // Constructors
    // toString(), equals(), hashCode()
}
