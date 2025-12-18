package tn.esprit.tpfoyer2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyer2.Entity.Reservation;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,String> {

    @Query("select r from Chambre c " +
           "join c.reservations r " +
           "join c.blocs b " +
           "join b.foyer f " +
           "join f.universite u " +
           "where r.anneeUniversitaire = :anneeUniversitaire " +
           "and u.nomUniversite = :nomUniversite")
    List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(
            @Param("anneeUniversitaire") Date anneeUniversitaire,
            @Param("nomUniversite") String nomUniversite);
}
