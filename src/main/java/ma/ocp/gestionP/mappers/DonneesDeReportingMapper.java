package ma.ocp.gestionP.mappers;

import ma.ocp.gestionP.dtos.DonneesDeReportingDTO;
import ma.ocp.gestionP.entities.DonneesDeReporting;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DonneesDeReportingMapper {

    DonneesDeReportingDTO toDto(DonneesDeReporting entity);

    DonneesDeReporting toEntity(DonneesDeReportingDTO dto);

    List<DonneesDeReportingDTO> toDtoList(List<DonneesDeReporting> entities);

    List<DonneesDeReporting> toEntityList(List<DonneesDeReportingDTO> dtos);
}
