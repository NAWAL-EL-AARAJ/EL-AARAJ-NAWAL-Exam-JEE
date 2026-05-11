package ma.enset.elaaraj.nawal.elaarajnawalexamjee.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.enset.elaaraj.nawal.elaarajnawalexamjee.enums.NiveauCouverture;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ContratSante extends ContratAssurance {
    @Enumerated(EnumType.STRING)
    private NiveauCouverture niveauCouverture;
    private Integer nbPersonnesCouvertes;
}