package ma.ocp.gestionP.repositories;

import ma.ocp.gestionP.entities.ResponsableVoyages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponsableVoyagesRepository extends JpaRepository<ResponsableVoyages, Long> {


    ResponsableVoyages findByUsermane(String username);
}
