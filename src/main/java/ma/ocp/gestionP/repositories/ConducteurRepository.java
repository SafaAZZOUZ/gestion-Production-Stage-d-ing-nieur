package ma.ocp.gestionP.repositories;

import ma.ocp.gestionP.entities.Conducteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ConducteurRepository extends JpaRepository<Conducteur, Long> {
    List<Conducteur> findByNom(String nom);

    List<Conducteur> findAllByDateEmBetween(LocalDate startDate, LocalDate endDate);

    List<Conducteur> findByVoyagesId(Long voyageId);
}
