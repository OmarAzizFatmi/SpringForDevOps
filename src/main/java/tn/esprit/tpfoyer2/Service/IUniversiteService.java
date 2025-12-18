package tn.esprit.tpfoyer2.Service;

import tn.esprit.tpfoyer2.Entity.Universite;
import java.util.List;

public interface IUniversiteService {
    List<Universite> retrieveUniversite();
    Universite updateUniveriste(Universite universite);
    Universite addBloc(Universite universite);
    Universite retrieveUniversite(long idUniversite);
    void removeUniversite(long idUniversite);
    Universite affecterFoyerAUniversite(long idFoyer, long idUniversite);
    Universite desaffecterFoyerAUniversite(long idUniversite);
}
