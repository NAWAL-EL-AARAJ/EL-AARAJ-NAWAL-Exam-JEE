package ma.enset.elaaraj.nawal.elaarajnawalexamjee.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.enset.elaaraj.nawal.elaarajnawalexamjee.enums.TypePaiement;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Paiement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date date;
    private Double montant;
    @Enumerated(EnumType.STRING)
    private TypePaiement typePaiement;
    @ManyToOne
    @JoinColumn(name = "contrat_id")
    private ContratAssurance contrat;
}