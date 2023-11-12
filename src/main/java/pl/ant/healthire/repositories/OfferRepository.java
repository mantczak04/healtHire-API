package pl.ant.healthire.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import pl.ant.healthire.entities.Offer;
import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Long> {

    @Query("SELECT o FROM Offer o JOIN o.office e WHERE e.city = :city")
    List<Offer> getAllByCity(@Param("city") String city);

    @Query("SELECT o FROM Offer o WHERE " +
            "o.title LIKE CONCAT('%', :query, '%')")
    List<Offer> searchOffersByTitle(String query);

    @Query("SELECT o FROM Offer o WHERE o.salary BETWEEN :minSalary AND :maxSalary")
    List<Offer> searchOffersBySalaryRange(@Param("minSalary")int minSalary,
                                          @Param("maxSalary")Integer maxSalary);

    @Modifying
    @Transactional
    @Query("UPDATE Offer o SET o.views = o.views + 1 WHERE o.id = :id")
    void incrementViewsByOfferId(@Param("id") Long id);

    @Query("SELECT o FROM Offer o JOIN o.office e WHERE e.city=:city" +
            " AND o.salary BETWEEN :minSalary AND :maxSalary")
    List<Offer> searchOffersByCityAndSalaryRange(
            @Param("city") String city,
            @Param("minSalary") Integer minSalary,
            @Param("maxSalary") Integer maxSalary
    );
}
