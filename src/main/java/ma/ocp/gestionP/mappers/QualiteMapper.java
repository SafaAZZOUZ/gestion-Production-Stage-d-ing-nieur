package ma.ocp.gestionP.mappers;

import ma.ocp.gestionP.dtos.QualiteDTO;
import ma.ocp.gestionP.entities.Qualite;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface QualiteMapper {

    QualiteDTO toDto(Qualite entity);

    Qualite toEntity(QualiteDTO dto);

    List<QualiteDTO> toDtoList(List<Qualite> entities);

    List<Qualite> toEntityList(List<QualiteDTO> dtos);
}
