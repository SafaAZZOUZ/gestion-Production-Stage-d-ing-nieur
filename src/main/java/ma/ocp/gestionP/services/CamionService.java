package ma.ocp.gestionP.services;

import ma.ocp.gestionP.dtos.CamionDTO;

import java.util.Date;
import java.util.List;

public interface CamionService {

    // Ajout d'un nouveau camion
    CamionDTO saveCamion(CamionDTO camionDTO);

    // Mise à jour d'un camion existant
    CamionDTO updateCamion(Long id, CamionDTO camionDTO);


    // Suppression d'un camion par ID
    void deleteCamionById(Long id);

    // Obtention de la liste de tous les camions
    List<CamionDTO> getAllCamions();

    // Obtention du nombre total de camions
    long getCamionsCount();

    // Vérification de l'existence d'un camion par ID
    public CamionDTO getCamionById(Long id);

    // Obtention des camions par marque
    List<CamionDTO> getCamionsByMarque(String marque);

    public List<CamionDTO> getCamionsForVoyage(Long voyageId);
    public List<CamionDTO> getCamionsByVoyageDate(Date startDate);
    //public CamionDTO getConsommationEtDistanceParMois(Long camionId);


}
