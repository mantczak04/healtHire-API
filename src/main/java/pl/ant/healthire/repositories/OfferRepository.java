package pl.ant.healthire.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.ant.healthire.entities.Offer;
import pl.ant.healthire.payload.NonDetailedOffer;

import java.util.Collection;
import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Long> {

    @Query("SELECT o FROM Offer o JOIN o.office e WHERE e.city = :city")
    List<Offer> getAllByCity(@Param("city") String city);
}
