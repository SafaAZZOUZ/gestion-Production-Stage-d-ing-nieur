package ma.ocp.gestionP.mappers;

import ma.ocp.gestionP.dtos.ConducteurDTO;
import ma.ocp.gestionP.entities.Conducteur;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ConducteurMapperImpl implements ConducteurMapper {

    @Override
    public ConducteurDTO toDto(Conducteur entity) {
        if (entity == null) {
            return null;
        }

        ConducteurDTO dto = new ConducteurDTO();
        BeanUtils.copyProperties(entity, dto, "tableauDeBord");

        return dto;
    }

    @Override
    public Conducteur toEntity(ConducteurDTO dto) {
        if (dto == null) {
            return null;
        }

        Conducteur entity = new Conducteur();
        BeanUtils.copyProperties(dto, entity, "tableauDeBord");

        return entity;
    }

    @Override
    public List<ConducteurDTO> toDtoList(List<Conducteur> entities) {
        return entities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Conducteur> toEntityList(List<ConducteurDTO> dtos) {
        if (dtos == null) {
            return new ArrayList<>();
        }

        return dtos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
