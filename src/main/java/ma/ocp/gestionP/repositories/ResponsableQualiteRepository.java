package ma.ocp.gestionP.repositories;

import ma.ocp.gestionP.entities.ResponsablesQualite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponsableQualiteRepository extends JpaRepository<ResponsablesQualite, Long> {

    ResponsablesQualite findByUsermane(String username);
}
