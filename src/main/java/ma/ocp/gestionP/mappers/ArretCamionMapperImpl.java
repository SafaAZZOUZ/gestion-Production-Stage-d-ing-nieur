package ma.ocp.gestionP.mappers;

import ma.ocp.gestionP.dtos.ArretCamionDTO;
import ma.ocp.gestionP.entities.ArretCamion;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component

public class ArretCamionMapperImpl implements ArretCamionMapper {

    private  CamionMapper camionMapper;

    @Autowired
    public void setCamionMapper(CamionMapper camionMapper) {
        this.camionMapper = camionMapper;
    }

    @Override
    public ArretCamionDTO toDto(ArretCamion entity) {
        if (entity == null) {
            return null;
        }

        ArretCamionDTO dto = new ArretCamionDTO();
        BeanUtils.copyProperties(entity, dto, "camion", "tableauDeBord"); // Exclude camion and tableauDeBord properties
        dto.setCamion(camionMapper.toDto(entity.getCamion()));

        return dto;
    }

    @Override
    public ArretCamion toEntity(ArretCamionDTO dto) {
        if (dto == null) {
            return null;
        }

        ArretCamion entity = new ArretCamion();
        BeanUtils.copyProperties(dto, entity, "camion", "tableauDeBord"); // Exclude camion and tableauDeBord properties
        entity.setCamion(camionMapper.toEntity(dto.getCamion()));

        return entity;
    }
    @Override
    public List<ArretCamionDTO> toDtoList(List<ArretCamion> entities) {
        return entities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ArretCamion> toEntityList(List<ArretCamionDTO> dtos) {
        return dtos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
