package ma.enset.elaaraj.nawal.elaarajnawalexamjee.repositories;

import ma.enset.elaaraj.nawal.elaarajnawalexamjee.entities.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {
    List<Paiement> findByContratId(Long contratId);
}