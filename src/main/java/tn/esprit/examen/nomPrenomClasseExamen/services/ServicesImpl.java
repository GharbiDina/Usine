package tn.esprit.examen.nomPrenomClasseExamen.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import tn.esprit.examen.nomPrenomClasseExamen.entities.*;
import tn.esprit.examen.nomPrenomClasseExamen.repositories.ContratRepo;
import tn.esprit.examen.nomPrenomClasseExamen.repositories.EmployeRepo;
import tn.esprit.examen.nomPrenomClasseExamen.repositories.IClientRepository;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ServicesImpl implements IServices {

    private final IClientRepository clientRepository;
    @Autowired
    UsineRepo usineRepo;
    @Autowired
    EmployeRepo employeRepo;
    @Autowired
    ContratRepo contratRepo;

    @Override
    public Client add(Client client) {
        return clientRepository.save(client);
    }

   @Scheduled(cron = "*/15 * * * * *")
    @Override
    public void test() {
        log.info("testing");
    }

    public Usine ajouterUsine(Usine u) {
        return usineRepo.save(u);
    }
    public void ajouterEmployesEtAffecterAUsine(long usineId, List<Employe>
            employes)
    {
// Rechercher l'événement
        List<Employe >ev = employeRepo.findAll();
        Usine usine = usineRepo.findById(usineId).get();
        // Associer la logistique à l'événement
        usine.setEmployes(ev);
        for (Employe employe : employes) {
            if (employe.getId() == null) {
                employeRepo.save(employe); // Persister l'employé si l'ID est null (nouvel employé)
            }
        }
        // Enregistrer la logistique
        usineRepo.save(usine);

    }
    public void affecterContratAEmploye(long contratId, long employeId)
    {
        Employe employe = employeRepo.findById(employeId).get();
        Contrat contrat = contratRepo.findById(contratId).get();
// on set le fils dans le parent :
        employe.setContrat(contrat);
        employeRepo.save(employe);

    }
}

