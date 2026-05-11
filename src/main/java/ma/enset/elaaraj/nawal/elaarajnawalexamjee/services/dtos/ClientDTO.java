package ma.enset.elaaraj.nawal.elaarajnawalexamjee.services.dtos;

import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ClientDTO {
    private Long id;
    private String nom;
    private String email;
}