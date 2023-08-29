package ma.ocp.gestionP.mappers;

import ma.ocp.gestionP.dtos.VoyageDTO;
import ma.ocp.gestionP.entities.Voyage;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VoyageMapperImpl implements VoyageMapper {

    private  ConducteurMapper conducteurMapper;
    private  CamionMapper camionMapper;

    @Autowired
    public void setConducteurMapper(ConducteurMapper conducteurMapper) {
        this.conducteurMapper = conducteurMapper;
    }

    @Autowired
    public void setCamionMapper(CamionMapper camionMapper) {
        this.camionMapper = camionMapper;
    }

    @Override
    public VoyageDTO toDto(Voyage entity) {
        if (entity == null) {
            return null;
        }

        VoyageDTO dto = new VoyageDTO();
        BeanUtils.copyProperties(entity, dto, "conducteurs"); // Exclure la copie de conducteurs
        dto.setCamions(camionMapper.toDtoList(entity.getCamions()));  // Utilisation d'une liste pour les camions
        dto.setConducteurs(conducteurMapper.toDtoList(entity.getConducteurs()));  // Utilisation d'une liste pour les conducteurs

        return dto;
    }

    @Override
    public Voyage toEntity(VoyageDTO dto) {
        if (dto == null) {
            return null;
        }

        Voyage entity = new Voyage();
        BeanUtils.copyProperties(dto, entity, "conducteurs"); // Exclure la copie de conducteurs
        entity.setCamions(camionMapper.toEntityList(dto.getCamions()));  // Utilisation d'une liste pour les camions
        entity.setConducteurs(conducteurMapper.toEntityList(dto.getConducteurs()));  // Utilisation d'une liste pour les conducteurs

        return entity;
    }

    @Override
    public List<VoyageDTO> toDtoList(List<Voyage> entities) {
        return entities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Voyage> toEntityList(List<VoyageDTO> dtos) {
        return dtos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
