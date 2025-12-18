package tn.esprit.tpfoyer2.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer2.Entity.Bloc;
import tn.esprit.tpfoyer2.Entity.Chambre;
import tn.esprit.tpfoyer2.Repository.BlocRepository;
import tn.esprit.tpfoyer2.Repository.ChambreRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class BlocService implements IBlocService {
    BlocRepository blocRepository;
    ChambreRepository chambreRepository;

    @Override
    public List<Bloc> retrieveBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc retrieveBloc(long idBloc) {
        return blocRepository.findById(idBloc).orElse(null);
    }

    @Override
    public void removeBloc(long idBloc) {
        blocRepository.deleteById(idBloc);
    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc).orElse(null);
        if (bloc == null) return null;

        List<Chambre> chambres = chambreRepository.findByNumChambreIn(numChambre);

        chambres.forEach(chambre -> chambre.setBlocs(bloc));

        bloc.getChambres().addAll(chambres);
        return blocRepository.save(bloc);
    }

}

