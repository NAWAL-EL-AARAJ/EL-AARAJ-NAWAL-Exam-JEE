package ma.enset.elaaraj.nawal.elaarajnawalexamjee.repositories;

import ma.enset.elaaraj.nawal.elaarajnawalexamjee.entities.ContratAssurance;
import ma.enset.elaaraj.nawal.elaarajnawalexamjee.enums.StatutContrat;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ContratAssuranceRepository extends JpaRepository<ContratAssurance, Long> {
    List<ContratAssurance> findByClientId(Long clientId);
    List<ContratAssurance> findByStatut(StatutContrat statut);
}