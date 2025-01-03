package tn.esprit.examen.nomPrenomClasseExamen.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Client;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Employe;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Usine;
import tn.esprit.examen.nomPrenomClasseExamen.services.IServices;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("examen")
@RestController
public class ClientRestController {
    private final IServices services;

    @PostMapping("/add")
    public Client add(@RequestBody Client client){
        return  services.add(client);
    }

    @PostMapping("/ajouterusine")
    public Usine ajouterProgrammeEtChaine(@RequestBody Usine p) {
        Usine programme = services.ajouterUsine(p);
        return programme;
    }
    @PostMapping("/creerEtAffecterEmploye")
    public ResponseEntity<String> ajouterEmployesEtAffecterAUsine(
            @RequestParam Long usineId,
            @RequestBody List<Employe>employes )  {
        services.ajouterEmployesEtAffecterAUsine(usineId, employes);
        return ResponseEntity.ok("Logistique ajoutée et associée avec succès !");


    }
    @PutMapping("/affecterContratEmploye/{contrat}/{empl}")
    public void affecterContratAEmploye(@PathVariable("contrat") Long contrat,
                                             @PathVariable("empl") Long empl) {
        services.affecterContratAEmploye(contrat, empl);


    }
}