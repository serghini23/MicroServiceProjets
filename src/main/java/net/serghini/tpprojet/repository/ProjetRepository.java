package net.serghini.tpprojet.repository;

import net.serghini.tpprojet.entities.Projet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetRepository extends JpaRepository<Projet, Long> {

}
