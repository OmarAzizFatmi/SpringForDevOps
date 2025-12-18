package tn.esprit.tpfoyer2.Service;

import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer2.Entity.Chambre;
import tn.esprit.tpfoyer2.Entity.TypeChambre;
import tn.esprit.tpfoyer2.Repository.ChambreRepository;

import java.time.Year;
import java.util.List;

@Service
public class ChamberService implements IChambreService {

    private final ChambreRepository chambreRepository;

    // ✅ Manual constructor for dependency injection
    public ChamberService(ChambreRepository chambreRepository) {
        this.chambreRepository = chambreRepository;
    }

    @Override
    public List<Chambre> retrieveAllChambres() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre updateChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre retrieveChambre(long idChambre) {
        return chambreRepository.findById(idChambre).orElse(null);
    }

    @Override
    public void removeChambre(Long idChambre) {
        chambreRepository.deleteById(idChambre);
    }

    @Override
    public List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC) {
        return chambreRepository.getChambresParBlocEtTypeJPQL(idBloc, typeC);
    }

    @Override
    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite, TypeChambre type) {
        int currentYear = Year.now().getValue();
        return chambreRepository.getChambresNonReserveParNomUniversiteEtTypeChambre(nomUniversite, type, currentYear);
    }
}
