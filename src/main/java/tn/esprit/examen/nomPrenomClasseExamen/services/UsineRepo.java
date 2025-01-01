package tn.esprit.examen.nomPrenomClasseExamen.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Usine;

@Repository
public interface UsineRepo extends JpaRepository<Usine,Long> {
}
