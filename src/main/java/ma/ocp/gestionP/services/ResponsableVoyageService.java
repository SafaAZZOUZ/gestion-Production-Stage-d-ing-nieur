package ma.ocp.gestionP.services;

import ma.ocp.gestionP.dtos.ResponsableVoyagesDTO;
import ma.ocp.gestionP.entities.ResponsableVoyages;

import java.util.List;

public interface ResponsableVoyageService {
    ResponsableVoyagesDTO getResposableById(int id);
    List<ResponsableVoyagesDTO> getResponsables();

    public ResponsableVoyagesDTO getResponsablesByUsername(String username);
    ResponsableVoyages saveResponsable(ResponsableVoyages responsablesVoyage);
    void saveResponsable(ResponsableVoyagesDTO responsablesVoyageDTO);
}
