package ma.ocp.gestionP.services;

import ma.ocp.gestionP.dtos.ArretCamionDTO;
import ma.ocp.gestionP.dtos.CamionDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface ArretCamionService {

    ArretCamionDTO saveArretCamion(ArretCamionDTO arretCamionDTO);

    ArretCamionDTO updateArretCamion(Long id, ArretCamionDTO arretCamionDTO);

    void deleteArretCamionById(Long id);

    void deleteArretsByCamionId(Long camionId);

    List<ArretCamionDTO> getAllArretsCamion();

    long getArretsCamionCount();

    boolean existsArretCamionById(Long id);

    List<ArretCamionDTO> getArretsCamionSortedByDate();

    List<ArretCamionDTO> getArretsCamionInDateRange(LocalDateTime start, LocalDateTime end);
     ArretCamionDTO getArretCamionById(Long id);
    public CamionDTO getCamionOfArret(Long id);
}
