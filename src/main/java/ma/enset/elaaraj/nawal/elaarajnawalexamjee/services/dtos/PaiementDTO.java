package ma.enset.elaaraj.nawal.elaarajnawalexamjee.services.dtos;

import lombok.*;
import ma.enset.elaaraj.nawal.elaarajnawalexamjee.enums.TypePaiement;
import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class PaiementDTO {
    private Long id;
    private Date date;
    private Double montant;
    private TypePaiement typePaiement;
    private Long contratId;
}