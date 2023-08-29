package ma.ocp.gestionP.repositories;

import ma.ocp.gestionP.entities.ArretCamion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ArretCamionRepository extends JpaRepository<ArretCamion, Long> {

    void deleteByCamionId(Long camionId);

    List<ArretCamion> findAllByOrderByDateHeureAsc();

    List<ArretCamion> findAllByDateHeureBetween(LocalDateTime start, LocalDateTime end);
}
