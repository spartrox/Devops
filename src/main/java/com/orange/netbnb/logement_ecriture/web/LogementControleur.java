package com.orange.netbnb.logement_ecriture.web;

import com.orange.netbnb.logement_ecriture.modele.Logement;
import com.orange.netbnb.logement_ecriture.repository.LogementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Collection;
import java.util.Optional;

@RestController
public class LogementControleur {

    @Autowired
    private LogementRepository logementRepository;


    /**
     * Récupération de tous les logements
     * @return
     */
    @GetMapping(path = "/logement", produces = "application/json")
    public Collection<Logement> lireLogement(){
        return logementRepository.findAll();
    }

    /**
     * Récupération d'un logement par son id
     * @param id
     * @return
     */
    @GetMapping(path = "/logement/{idLogement}", produces = "application/json")
    public Optional<Logement> lireLogement(@PathVariable String id){
        return logementRepository.findById(id);
    }

    /**
     * Création d'un logement
     * @param logement
     */
    @PostMapping(path = "/logement", consumes = "application/json")
    public void creerLogement(@RequestBody Logement logement){
        logementRepository.insert(logement);
    }

    /**
     * Modification d'un logement
     * @param logement
     * @param idLogement
     */
    @PutMapping(path = "/logement/{idLogement}", consumes = "application/json")
    public void modifierLogement(@RequestBody Logement logement, @PathVariable String idLogement){
        logement.setId(idLogement);
        logementRepository.save(logement);
    }

    /**
     * Suppression d'un logement
     * @param idLogement
     */
    @DeleteMapping(path = "/logement/{idLogement}")
    public void supprimerLogement(@PathVariable String idLogement){
       logementRepository.deleteById(idLogement);
    }
}
