package tn.esprit.tpfoyer2.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer2.Entity.Foyer;
import tn.esprit.tpfoyer2.Entity.Universite;
import tn.esprit.tpfoyer2.Repository.FoyerRepository;
import tn.esprit.tpfoyer2.Repository.UniversiteRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteService implements IUniversiteService {
    UniversiteRepository universiteRepository;
    FoyerRepository foyerRepository;

    @Override
    public List<Universite> retrieveUniversite() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite updateUniveriste(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public Universite addBloc(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public Universite retrieveUniversite(long idUniversite) {
        return universiteRepository.findById(idUniversite).orElse(null);
    }

    @Override
    public void removeUniversite(long idUniversite) {
        universiteRepository.deleteById(idUniversite);
    }

    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, long idUniversite) {
        Foyer foyer = foyerRepository.findById(idFoyer)
                .orElseThrow(() -> new RuntimeException("Foyer not found"));
        Universite universite = universiteRepository.findById(idUniversite)
                .orElseThrow(() -> new RuntimeException("Universite not found"));

        universite.setFoyer(foyer);
        foyer.setUniversite(universite);

        foyerRepository.save(foyer);
        return universiteRepository.save(universite);
    }


    @Override
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);

        if (universite == null || universite.getFoyer() == null) {
            return universite;
        }

        Foyer foyer = universite.getFoyer();
        universite.setFoyer(null);
        foyer.setUniversite(null);

        universiteRepository.save(universite);
        foyerRepository.save(foyer);

        return universite;
    }

}