package pl.ant.healthire.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ant.healthire.entities.Office;

public interface OfficeRepository extends JpaRepository<Office, Long> {
}
