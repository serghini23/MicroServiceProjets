package net.serghini.tpprojet.dtos;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class ResponseAllProjetDto {
    private Long id ;
    private String titre ;
    private String  description;
    private Long idChercheur;
    private Long idEnseignant;


}
