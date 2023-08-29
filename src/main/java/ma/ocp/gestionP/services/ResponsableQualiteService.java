package ma.ocp.gestionP.services;


import ma.ocp.gestionP.dtos.ResponsablesQualiteDTO;
import ma.ocp.gestionP.entities.ResponsablesQualite;

import java.util.List;

public interface ResponsableQualiteService {
    ResponsablesQualiteDTO getResposableById(int id);
    List<ResponsablesQualiteDTO> getResponsables();
    public ResponsablesQualiteDTO getResponsablesByUsername(String username);
    ResponsablesQualite saveResponsable(ResponsablesQualite responsablesQualite);
    void saveResponsable(ResponsablesQualiteDTO responsablesQualiteDTO);
}
