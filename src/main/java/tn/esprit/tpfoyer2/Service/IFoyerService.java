package tn.esprit.tpfoyer2.Service;

import tn.esprit.tpfoyer2.Entity.Foyer;

import java.util.List;

public interface IFoyerService {
    List<Foyer> retrieveAllFoyers();

    Foyer addFoyer(Foyer f);

    Foyer updateFoyer(Foyer f);

    Foyer retrieveFoyer(long idFoyer);

    void removeFoyer(long idFoyer);
}
