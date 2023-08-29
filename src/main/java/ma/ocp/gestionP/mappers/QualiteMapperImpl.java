package ma.ocp.gestionP.mappers;

import ma.ocp.gestionP.dtos.QualiteDTO;
import ma.ocp.gestionP.entities.Qualite;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class QualiteMapperImpl implements QualiteMapper {

    @Override
    public QualiteDTO toDto(Qualite entity) {
        if (entity == null) {
            return null;
        }

        QualiteDTO dto = new QualiteDTO();
        BeanUtils.copyProperties(entity, dto, "tableauDeBord");


        return dto;
    }

    @Override
    public Qualite toEntity(QualiteDTO dto) {
        if (dto == null) {
            return null;
        }

        Qualite entity = new Qualite();
        BeanUtils.copyProperties(dto, entity, "tableauDeBord");


        return entity;
    }
    @Override
    public List<QualiteDTO> toDtoList(List<Qualite> entities) {
        return entities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Qualite> toEntityList(List<QualiteDTO> dtos) {
        return dtos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
