package tn.esprit.tpfoyer2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyer2.Entity.Bloc;

@Repository
public interface BlocRepository extends JpaRepository<Bloc,Long> {
}
