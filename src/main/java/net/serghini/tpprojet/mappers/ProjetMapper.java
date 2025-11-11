package net.serghini.tpprojet.mappers;

import net.serghini.tpprojet.dtos.RequestProjetDto;
import net.serghini.tpprojet.dtos.ResponseAllProjetDto;
import net.serghini.tpprojet.dtos.ResponseProjetDto;
import net.serghini.tpprojet.entities.Projet;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProjetMapper {
    public Projet dto_to_entity(RequestProjetDto requestProjetDto) {
        Projet projet = new Projet();
        BeanUtils.copyProperties(requestProjetDto, projet);
        return projet;
    }


    public ResponseProjetDto entity_to_dto(Projet projet) {
        ResponseProjetDto responseProjetDto = new ResponseProjetDto();
        BeanUtils.copyProperties(projet, responseProjetDto);
        return responseProjetDto;
    }
    public ResponseAllProjetDto to_dto( Projet projet) {
        ResponseAllProjetDto responseAllProjetDto = new ResponseAllProjetDto();
        BeanUtils.copyProperties(projet, responseAllProjetDto);
        return responseAllProjetDto;
    }

}
