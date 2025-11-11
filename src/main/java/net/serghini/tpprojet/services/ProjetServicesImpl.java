package net.serghini.tpprojet.services;

import feign.FeignException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import net.serghini.tpprojet.client.ChercheurClient;
import net.serghini.tpprojet.client.EnseignantClient;
import net.serghini.tpprojet.dtos.RequestProjetDto;
import net.serghini.tpprojet.dtos.ResponseAllProjetDto;
import net.serghini.tpprojet.dtos.ResponseProjetDto;
import net.serghini.tpprojet.entities.Projet;
import net.serghini.tpprojet.mappers.ProjetMapper;
import net.serghini.tpprojet.repository.ProjetRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
@AllArgsConstructor
public class ProjetServicesImpl implements ProjetServices {
    private ProjetRepository  projetRepository;
    private ProjetMapper projetMapper;
    private ChercheurClient chercheurClient;
    private EnseignantClient enseignantClient;

    @Override
    public ResponseProjetDto addProjet(RequestProjetDto requestProjetDto) {
        try {
            chercheurClient.getChercheurById(requestProjetDto.getIdChercheur());
            enseignantClient.getEnseignantById(requestProjetDto.getIdEnseignant());
        } catch (FeignException.NotFound nf) {
            throw new IllegalArgumentException("Le chercheur ou l'enseignant  n'existe pas pour l'id fourni");
        }
        Projet projet = projetMapper.dto_to_entity(requestProjetDto);
        Projet saved = projetRepository.save(projet);
        return projetMapper.entity_to_dto(saved);
    }

    @Override
    public ResponseProjetDto getProjetById(Long id) {
        Projet projet = projetRepository.findById(id).orElseThrow();
        ResponseProjetDto dto = projetMapper.entity_to_dto(projet);

        return dto;
    }

    @Override
    public List<ResponseAllProjetDto> getALLEnseignants() {
        List<Projet> projets = projetRepository.findAll();
        List<ResponseAllProjetDto> dtos = new ArrayList<>();
        for (Projet p : projets) {
            dtos.add(projetMapper.to_dto(p));
        }

        return dtos;
    }

    @Override
    public ResponseProjetDto updateProjet(Long id, RequestProjetDto requestProjetDto) {

        Projet new_projet = projetMapper.dto_to_entity(requestProjetDto);
        Projet projet1 = projetRepository.findById(id).orElseThrow();
        if (new_projet.getTitre()!=null) projet1.setTitre(new_projet.getTitre());
        if (new_projet.getDescription()!=null)  projet1.setDescription(new_projet.getDescription());
        Projet saved = projetRepository.save(projet1);

        return projetMapper.entity_to_dto(saved);
    }

    @Override
    public void deleteProjet(Long id) {
        projetRepository.deleteById(id);

    }



    @Override
    public long countByIdEnseignant(Long idEnseignant) {
        return projetRepository.countByIdEnseignant(idEnseignant);
    }

    @Override
    public long countByIdChercheur(Long idChercheur) {
        return projetRepository.countByIdChercheur(idChercheur);
    }



}
