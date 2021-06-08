package com.orange.netbnb.logement_ecriture.repository;

import com.orange.netbnb.logement_ecriture.modele.Logement;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogementRepository extends MongoRepository<Logement, String> {


}
