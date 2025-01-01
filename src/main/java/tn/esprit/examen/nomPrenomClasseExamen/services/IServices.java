package tn.esprit.examen.nomPrenomClasseExamen.services;

import tn.esprit.examen.nomPrenomClasseExamen.entities.Client;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Employe;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Usine;

import java.util.List;

public interface IServices {
    Client add(Client client);
    public Usine ajouterUsine(Usine u) ;;
    void test();
    public void ajouterEmployesEtAffecterAUsine(long usineId, List<Employe>
            employes) ;
}
