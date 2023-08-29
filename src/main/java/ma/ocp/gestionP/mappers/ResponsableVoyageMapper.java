package ma.ocp.gestionP.mappers;


import ma.ocp.gestionP.dtos.ResponsableVoyagesDTO;
import ma.ocp.gestionP.entities.ResponsableVoyages;

public interface ResponsableVoyageMapper {
    ResponsableVoyagesDTO ToDTO(ResponsableVoyages responsableVoyages);
    ResponsableVoyages DTOTo(ResponsableVoyagesDTO responsableVoyagesDTO);
}
