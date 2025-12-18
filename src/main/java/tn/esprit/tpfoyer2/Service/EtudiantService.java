package tn.esprit.tpfoyer2.Service;

import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer2.Entity.Etudiant;
import tn.esprit.tpfoyer2.Repository.EtudiantRepository;
import java.util.List;

@Service
public class EtudiantService implements IEtudiantService {

    private final EtudiantRepository etudiantRepository;

    // ✅ Constructor for dependency injection
    public EtudiantService(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public List<Etudiant> addEtudiants(List<Etudiant> etudiants) {
        return etudiantRepository.saveAll(etudiants);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(long idEtudiant) {
        return etudiantRepository.findById(idEtudiant).orElse(null);
    }

    @Override
    public void removeEtudiant(long idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }
}
