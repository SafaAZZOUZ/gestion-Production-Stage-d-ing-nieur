package ma.ocp.gestionP.mappers;

import lombok.AllArgsConstructor;
import ma.ocp.gestionP.dtos.ResponsableVoyagesDTO;
import ma.ocp.gestionP.entities.ResponsableVoyages;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor

public class ResponsableVoyageMapperImpl implements ResponsableVoyageMapper {
    @Override
    public ResponsableVoyagesDTO ToDTO(ResponsableVoyages responsableVoyages) {
        ResponsableVoyagesDTO responsableVoyagesDTO = new ResponsableVoyagesDTO();
        BeanUtils.copyProperties(responsableVoyages, responsableVoyagesDTO);
        return responsableVoyagesDTO;
    }

    @Override
    public ResponsableVoyages DTOTo(ResponsableVoyagesDTO responsableVoyagesDTO) {
        ResponsableVoyages responsableVoyages = new ResponsableVoyages();
        BeanUtils.copyProperties(responsableVoyagesDTO, responsableVoyages);
        return responsableVoyages;
    }
}
