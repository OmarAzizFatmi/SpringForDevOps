package tn.esprit.tpfoyer2.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer2.Entity.Universite;
import tn.esprit.tpfoyer2.Service.IUniversiteService;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/universite")
public class UniversiteRestController {
   IUniversiteService universiteService;

    @GetMapping("/retrieve-universites")
    public List<Universite> getUniversites() {
        return universiteService.retrieveUniversite();
    }

    @GetMapping("/retrieve-universite/{universite-id}")
    public Universite retrieveUniversite(@PathVariable("universite-id") Long universiteId) {
        return universiteService.retrieveUniversite(universiteId);
    }

    @PostMapping("/add-universite")
    public Universite addUniversite(@RequestBody Universite universite) {
        return universiteService.addBloc(universite);
    }

    @DeleteMapping("/remove-universite/{universite-id}")
    public void removeUniversite(@PathVariable("universite-id") Long universiteId) {
        universiteService.removeUniversite(universiteId);
    }

    @PutMapping("/update-universite")
    public Universite updateUniversite(@RequestBody Universite universite) {
        return universiteService.updateUniveriste(universite);
    }

    @PutMapping("/affecter-foyer-a-universite/{idFoyer}/{idUniversite}")
    public Universite affecterFoyerAUniversite(
            @PathVariable long idFoyer,
            @PathVariable long idUniversite) {
        return universiteService.affecterFoyerAUniversite(idFoyer, idUniversite);
    }


    @PutMapping("/desaffecter-foyer-a-universite/{idUniversite}")
    public Universite desaffecterFoyerAUniversite(@PathVariable("idUniversite") long idUniversite) {
        return universiteService.desaffecterFoyerAUniversite(idUniversite);
    }
}