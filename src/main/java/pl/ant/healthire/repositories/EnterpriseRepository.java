package pl.ant.healthire.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ant.healthire.entities.Enterprise;

public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {
}
