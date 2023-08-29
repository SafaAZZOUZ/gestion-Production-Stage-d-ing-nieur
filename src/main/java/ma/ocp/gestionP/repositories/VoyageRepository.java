package ma.ocp.gestionP.repositories;

import ma.ocp.gestionP.entities.Voyage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VoyageRepository extends JpaRepository<Voyage, Long> {
    List<Voyage> findByDateDepart(LocalDate date);

    List<Voyage> findByConducteurs_Id(Long id);  // Remplacer conducteurId par id

    List<Voyage> findByCamions_Id(Long camionId);
}
