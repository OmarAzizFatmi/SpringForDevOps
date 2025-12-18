package tn.esprit.tpfoyer2.Controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer2.Entity.Chambre;
import tn.esprit.tpfoyer2.Entity.TypeChambre;
import tn.esprit.tpfoyer2.Service.IChambreService;
import java.util.List;

@RestController
@RequestMapping("/chamber")
public class ChamberRestController {
    public ChamberRestController(IChambreService chambreService) {
        this.chambreService = chambreService;
    }
    private final IChambreService chambreService;

    // http://localhost:3306/tpfoyer/chambre/retrieve-all-chambres
    @GetMapping("/retrieve-all-chambers")
    public List<Chambre> getChambres() {
        return chambreService.retrieveAllChambres();
    }

    // http://localhost:3306/tpfoyer/chambre/retrieve-chamber/{chamber-id}
    @GetMapping("/retrieve-chamber/{chamber-id}")
    public Chambre retrieveChambre(@PathVariable("chamber-id") Long chId) {
        return chambreService.retrieveChambre(chId);
    }

    // http://localhost:3306/tpfoyer/chamber/add-chamber
    @PostMapping("/add-chamber")
    public Chambre addChambre(@RequestBody Chambre c) {
        return chambreService.addChambre(c);
    }

    // http://localhost:3306/tpfoyer/chambre/remove-chamber/{chamber-id}
    @DeleteMapping("/remove-chamber/{chamber-id}")
    public void removeChamber(@PathVariable("chamber-id") Long chId) {
        chambreService.removeChambre(chId);
    }

    // http://localhost:3306/tpfoyer/chambre/modify-chamber
    @PutMapping("/modify-chamber")
    public Chambre modifyChamber(@RequestBody Chambre c) {
        return chambreService.updateChambre(c);
    }

    @GetMapping("/by-bloc-and-type/{idBloc}/{type}")
    public List<Chambre> getChambresParBlocEtType(@PathVariable("idBloc") long idBloc,
                                                  @PathVariable("type") TypeChambre type) {
        return chambreService.getChambresParBlocEtType(idBloc, type);
    }

    @GetMapping("/non-reservees")
    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(@RequestParam String nomUniversite,
                                                                            @RequestParam TypeChambre type) {
        return chambreService.getChambresNonReserveParNomUniversiteEtTypeChambre(nomUniversite, type);
    }
}
