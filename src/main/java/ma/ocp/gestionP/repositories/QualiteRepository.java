package ma.ocp.gestionP.repositories;

import ma.ocp.gestionP.entities.Qualite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QualiteRepository extends JpaRepository<Qualite, Long> {

}
