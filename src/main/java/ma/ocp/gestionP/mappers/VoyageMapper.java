package ma.ocp.gestionP.mappers;

import ma.ocp.gestionP.dtos.VoyageDTO;
import ma.ocp.gestionP.entities.Voyage;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface VoyageMapper {

    VoyageDTO toDto(Voyage entity);

    Voyage toEntity(VoyageDTO dto);
    List<VoyageDTO> toDtoList(List<Voyage> entities);

    List<Voyage> toEntityList(List<VoyageDTO> dtos);

}
