package ma.ocp.gestionP.mappers;

import ma.ocp.gestionP.dtos.ConducteurDTO;
import ma.ocp.gestionP.entities.Conducteur;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ConducteurMapper {

    ConducteurDTO toDto(Conducteur entity);

    Conducteur toEntity(ConducteurDTO dto);
    List<ConducteurDTO> toDtoList(List<Conducteur> entities);

    List<Conducteur> toEntityList(List<ConducteurDTO> dtos);
}
