package ma.enset.elaaraj.nawal.elaarajnawalexamjee.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.enset.elaaraj.nawal.elaarajnawalexamjee.enums.StatutContrat;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ContratAssurance {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date dateSouscription;
    @Enumerated(EnumType.STRING)
    private StatutContrat statut;
    @Temporal(TemporalType.DATE)
    private Date dateValidation;
    private Double montantCotisation;
    private Integer dureeContrat;
    private Double tauxCouverture;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @OneToMany(mappedBy = "contrat", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Paiement> paiements;
}