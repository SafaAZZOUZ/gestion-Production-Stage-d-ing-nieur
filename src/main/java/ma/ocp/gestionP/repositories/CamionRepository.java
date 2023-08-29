package ma.ocp.gestionP.repositories;

import ma.ocp.gestionP.entities.Camion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CamionRepository extends JpaRepository<Camion, Long> {
    List<Camion> findByMarque(String marque);

    List<Camion> findAllByVoyages_DateDepart(Date startDate);


    List<Camion> findByVoyages_Id(Long voyageId);

}


