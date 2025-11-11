package net.serghini.tpprojet.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RequestProjetDto {
    private String titre ;
    private String  description;
    private Long idChercheur;
    private Long idEnseignant;
}
