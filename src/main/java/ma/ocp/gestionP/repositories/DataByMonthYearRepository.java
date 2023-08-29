package ma.ocp.gestionP.repositories;

import ma.ocp.gestionP.entities.DataByMonthYear;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataByMonthYearRepository extends JpaRepository<DataByMonthYear, String> {
}
