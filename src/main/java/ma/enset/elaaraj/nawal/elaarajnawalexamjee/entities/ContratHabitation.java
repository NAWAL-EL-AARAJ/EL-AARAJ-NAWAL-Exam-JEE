package ma.enset.elaaraj.nawal.elaarajnawalexamjee.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.enset.elaaraj.nawal.elaarajnawalexamjee.enums.TypeLogement;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ContratHabitation extends ContratAssurance {
    @Enumerated(EnumType.STRING)
    private TypeLogement typeLogement;
    private String adresse;
    private Double superficie;
}