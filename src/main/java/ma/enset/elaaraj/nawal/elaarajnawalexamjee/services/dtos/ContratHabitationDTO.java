package ma.enset.elaaraj.nawal.elaarajnawalexamjee.services.dtos;

import lombok.*;
import ma.enset.elaaraj.nawal.elaarajnawalexamjee.enums.StatutContrat;
import ma.enset.elaaraj.nawal.elaarajnawalexamjee.enums.TypeLogement;
import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ContratHabitationDTO {
    private Long id;
    private Date dateSouscription;
    private StatutContrat statut;
    private Date dateValidation;
    private Double montantCotisation;
    private Integer dureeContrat;
    private Double tauxCouverture;
    private Long clientId;
    private String clientNom;
    private TypeLogement typeLogement;
    private String adresse;
    private Double superficie;
}