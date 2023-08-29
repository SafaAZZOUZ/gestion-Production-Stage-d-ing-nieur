package ma.ocp.gestionP.mappers;

import ma.ocp.gestionP.dtos.CamionDTO;
import ma.ocp.gestionP.entities.Camion;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CamionMapperImpl implements CamionMapper {

    @Override
    public CamionDTO toDto(Camion entity) {
        if (entity == null) {
            return null;
        }

        CamionDTO dto = new CamionDTO();
        BeanUtils.copyProperties(entity, dto, "voyage");

        return dto;
    }

    @Override
    public Camion toEntity(CamionDTO dto) {
        if (dto == null) {
            return null;
        }

        Camion entity = new Camion();
        BeanUtils.copyProperties(dto, entity, "voyage");

        return entity;
    }

    @Override
    public List<CamionDTO> toDtoList(List<Camion> entities) {
        return entities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Camion> toEntityList(List<CamionDTO> dtos) {
        if (dtos == null) {
            return new ArrayList<>();
        }

        return dtos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
