package tn.esprit.tpfoyer2.Controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer2.Entity.Reservation;
import tn.esprit.tpfoyer2.Service.IReservationService;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationRestController {
    public ReservationRestController(IReservationService reservationService) {
        this.reservationService = reservationService;
    }
    private final IReservationService reservationService;

    @GetMapping("/retrieve-all-reservations")
    public List<Reservation> getReservations() {
        return reservationService.retrieveAllReservation();
    }

    @GetMapping("/retrieve-reservation/{reservation-id}")
    public Reservation retrieveReservation(@PathVariable("reservation-id") String reservationId) {
        return reservationService.retrieveReservation(reservationId);
    }

    @PutMapping("/update-reservation")
    public Reservation updateReservation(@RequestBody Reservation res) {
        return reservationService.updateReservation(res);
    }

    @GetMapping("/by-annee-et-universite")
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(@RequestParam Date anneeUniversitaire,
                                                                                @RequestParam String nomUniversite) {
        return reservationService.getReservationParAnneeUniversitaireEtNomUniversite(anneeUniversitaire, nomUniversite);
    }

    @PostMapping("/add-reservation")
    public Reservation ajouterReservation(@RequestBody Reservation reservation) {
        return reservationService.ajouterReservation(reservation);
    }
}
