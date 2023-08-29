package ma.ocp.gestionP.mappers;

import ma.ocp.gestionP.dtos.ArretCamionDTO;
import ma.ocp.gestionP.entities.ArretCamion;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ArretCamionMapper {

    ArretCamionDTO toDto(ArretCamion entity);

    ArretCamion toEntity(ArretCamionDTO dto);

    List<ArretCamionDTO> toDtoList(List<ArretCamion> entities);

    List<ArretCamion> toEntityList(List<ArretCamionDTO> dtos);
}
