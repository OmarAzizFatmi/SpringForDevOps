package tn.esprit.tpfoyer2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.transaction.annotation.Ejb3TransactionAnnotationParser;

public interface BlocRepo extends JpaRepository<tn.esprit.tpfoyer2.Entity.Bloc, Long> {

}
