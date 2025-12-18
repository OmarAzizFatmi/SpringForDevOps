package tn.esprit.tpfoyer2.Scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer2.Entity.Chambre;
import tn.esprit.tpfoyer2.Repository.ChambreRepository;

import java.time.Year;
import java.util.List;

@Service
public class NonReservedChambresScheduler {

    private final ChambreRepository chambreRepository;

    public NonReservedChambresScheduler(ChambreRepository chambreRepository) {
        this.chambreRepository = chambreRepository;
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void afficherChambresNonReserveesCetteAnneePourToutesUniversites() {
        int currentYear = Year.now().getValue();
        // Using a broad query: all chambres, then filter by reservations for current year
        // The assignment only requires displaying, so we log the count.
        List<Chambre> allChambres = chambreRepository.findAll();
        long nonReserveesCount = allChambres.stream()
                .filter(c -> c.getReservations() == null ||
                        c.getReservations().stream().noneMatch(r -> {
                            if (r.getAnneeUniversitaire() == null) return false;
                            return (r.getAnneeUniversitaire().getYear() + 1900) == currentYear && r.isEstValide();
                        }))
                .count();
        System.out.println("Nombre de chambres non réservées cette année pour toutes les universités : " + nonReserveesCount);
    }
}
