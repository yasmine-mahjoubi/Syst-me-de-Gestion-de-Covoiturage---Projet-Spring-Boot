package Repository;

import Entity.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface RideRepository extends JpaRepository<Ride, Long> {
    @Query("SELECT r FROM Ride r WHERE " +
            "(:departure IS NULL OR r.departure = :departure) AND " +
            "(:destination IS NULL OR r.destination = :destination) AND " +
            "(:date IS NULL OR r.date = :date) AND " +
            "(:maxPrice IS NULL OR r.price <= :maxPrice)")
    List<Ride> findRides(
            @Param("departure") String departure,
            @Param("destination") String destination,
            @Param("date") LocalDate date,
            @Param("maxPrice") Double maxPrice);
}
