package net.serghini.tpprojet.web;

import lombok.AllArgsConstructor;
import net.serghini.tpprojet.dtos.RequestProjetDto;
import net.serghini.tpprojet.dtos.ResponseAllProjetDto;
import net.serghini.tpprojet.dtos.ResponseProjetDto;
import net.serghini.tpprojet.services.ProjetServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/projets")
@AllArgsConstructor
public class ProjetController {

    private ProjetServices  projetServices;
    @GetMapping
    public ResponseEntity<List<ResponseAllProjetDto>> getAllProjets() {
        return ResponseEntity.ok(projetServices.getALLEnseignants());
    }
    @GetMapping("{id}")
    public ResponseEntity<ResponseProjetDto> getProjetById(@PathVariable Long id) {
        return ResponseEntity.ok(projetServices.getProjetById(id));

    }
    @PostMapping
    public ResponseEntity<ResponseProjetDto> creatEnse(@RequestBody RequestProjetDto requestProjetDto) {
        return     ResponseEntity.ok(projetServices.addProjet(requestProjetDto));

    }
    @PutMapping("{id}")
    public ResponseEntity<ResponseProjetDto> updateEnse(@PathVariable Long id, @RequestBody RequestProjetDto requestProjetDto) {
        return ResponseEntity.ok(projetServices.updateProjet(id, requestProjetDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity DeletEnse(@PathVariable Long id){
        projetServices.deleteProjet(id);
        return ResponseEntity.ok().build();
    }



}
