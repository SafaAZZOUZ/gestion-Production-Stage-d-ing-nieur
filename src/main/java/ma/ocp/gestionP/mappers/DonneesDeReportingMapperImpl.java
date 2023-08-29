package ma.ocp.gestionP.mappers;

import ma.ocp.gestionP.dtos.DonneesDeReportingDTO;
import ma.ocp.gestionP.entities.DonneesDeReporting;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DonneesDeReportingMapperImpl implements DonneesDeReportingMapper {

    @Override
    public DonneesDeReportingDTO toDto(DonneesDeReporting entity) {
        DonneesDeReportingDTO dto = new DonneesDeReportingDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public DonneesDeReporting toEntity(DonneesDeReportingDTO dto) {
        DonneesDeReporting entity = new DonneesDeReporting();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    @Override
    public List<DonneesDeReportingDTO> toDtoList(List<DonneesDeReporting> entities) {
        return entities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<DonneesDeReporting> toEntityList(List<DonneesDeReportingDTO> dtos) {
        return dtos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
