package ma.ocp.gestionP.mappers;

import ma.ocp.gestionP.dtos.CamionDTO;
import ma.ocp.gestionP.entities.Camion;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CamionMapper {

    CamionDTO toDto(Camion entity);

    Camion toEntity(CamionDTO dto);

    List<CamionDTO> toDtoList(List<Camion> entities);

    List<Camion> toEntityList(List<CamionDTO> dtos);
}
