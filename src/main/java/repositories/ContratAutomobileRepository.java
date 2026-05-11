package ma.enset.elaaraj.nawal.elaarajnawalexamjee.repositories;

import ma.enset.elaaraj.nawal.elaarajnawalexamjee.entities.ContratAutomobile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ContratAutomobileRepository extends JpaRepository<ContratAutomobile, Long> {
    List<ContratAutomobile> findByMarque(String marque);
}