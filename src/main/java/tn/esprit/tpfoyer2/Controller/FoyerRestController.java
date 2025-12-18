package tn.esprit.tpfoyer2.Controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer2.Entity.Foyer;
import tn.esprit.tpfoyer2.Service.IFoyerService;
import java.util.List;

@RestController
@RequestMapping("/foyer")
public class FoyerRestController {
    public FoyerRestController(IFoyerService foyerService) {
        this.foyerService = foyerService;
    }
    private final IFoyerService foyerService;

    @GetMapping("/retrieve-all-foyers")
    public List<Foyer> getFoyers() {
        return foyerService.retrieveAllFoyers();
    }

    @GetMapping("/retrieve-foyer/{foyer-id}")
    public Foyer retrieveFoyer(@PathVariable("foyer-id") Long foyerId) {
        return foyerService.retrieveFoyer(foyerId);
    }

    @PostMapping("/add-foyer")
    public Foyer addFoyer(@RequestBody Foyer f) {
        return foyerService.addFoyer(f);
    }

    @DeleteMapping("/remove-foyer/{foyer-id}")
    public void removeFoyer(@PathVariable("foyer-id") Long foyerId) {
        foyerService.removeFoyer(foyerId);
    }

    @PutMapping("/update-foyer")
    public Foyer updateFoyer(@RequestBody Foyer f) {
        return foyerService.updateFoyer(f);
    }
}
