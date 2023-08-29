package ma.ocp.gestionP.mappers;

import ma.ocp.gestionP.dtos.ResponsablesQualiteDTO;
import ma.ocp.gestionP.entities.ResponsablesQualite;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ResponsableQualiteMapperImpl implements ResponsableQualiteMapper {
    @Override
    public ResponsablesQualiteDTO ToDTO(ResponsablesQualite responsablesQualite) {
        ResponsablesQualiteDTO responsablesQualiteDTO = new ResponsablesQualiteDTO();
        BeanUtils.copyProperties(responsablesQualite, responsablesQualiteDTO);
        return responsablesQualiteDTO;
    }

    @Override
    public ResponsablesQualite DTOTo(ResponsablesQualiteDTO responsablesQualiteDTO) {
        ResponsablesQualite responsablesQualite = new ResponsablesQualite();
        BeanUtils.copyProperties(responsablesQualiteDTO, responsablesQualite);
        return responsablesQualite;
    }
}
