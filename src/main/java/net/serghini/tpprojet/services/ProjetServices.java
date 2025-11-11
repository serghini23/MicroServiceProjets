package net.serghini.tpprojet.services;

import net.serghini.tpprojet.dtos.RequestProjetDto;
import net.serghini.tpprojet.dtos.ResponseAllProjetDto;
import net.serghini.tpprojet.dtos.ResponseProjetDto;

import java.util.List;

public interface ProjetServices {
    public ResponseProjetDto addProjet(RequestProjetDto  requestProjetDto);
    public ResponseProjetDto getProjetById(Long id);
    public List<ResponseAllProjetDto> getALLEnseignants();
    public ResponseProjetDto updateProjet(Long id, RequestProjetDto  requestProjetDto);
    public void deleteProjet(Long id);
    long countByIdEnseignant(Long idEnseignant);
    long countByIdChercheur(Long idChercheur);

}
