package ma.ocp.gestionP.repositories;

import ma.ocp.gestionP.entities.DonneesDeReporting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonneesDeReportingRepository extends JpaRepository<DonneesDeReporting, Long> {
}
