package ma.ocp.gestionP.mappers;
import ma.ocp.gestionP.dtos.ResponsablesQualiteDTO;
import ma.ocp.gestionP.entities.ResponsablesQualite;

public interface ResponsableQualiteMapper {
    ResponsablesQualiteDTO ToDTO(ResponsablesQualite responsablesQualite);
    ResponsablesQualite DTOTo(ResponsablesQualiteDTO responsablesQualiteDTO);
}
