package tn.esprit.tpfoyer2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyer2.Entity.Chambre;
import tn.esprit.tpfoyer2.Entity.TypeChambre;

import java.util.List;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre,Long> {
    List<Chambre> findByNumChambreIn(List<Long> numChambres);

    List<Chambre> findByBlocsIdBlocAndTypeC(Long idBloc, TypeChambre typeC);

    @Query("select c from Chambre c where c.blocs.idBloc = :idBloc and c.typeC = :typeC")
    List<Chambre> getChambresParBlocEtTypeJPQL(@Param("idBloc") Long idBloc, @Param("typeC") TypeChambre typeC);

    @Query("select c from Chambre c " +
           "join c.blocs b " +
           "join b.foyer f " +
           "join f.universite u " +
           "left join c.reservations r " +
           "with function('YEAR', r.anneeUniversitaire) = :annee and r.estValide = true " +
           "where u.nomUniversite = :nomUniversite " +
           "and c.typeC = :type " +
           "and r is null")
    List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(@Param("nomUniversite") String nomUniversite,
                                                                      @Param("type") TypeChambre type,
                                                                      @Param("annee") int annee);
}
