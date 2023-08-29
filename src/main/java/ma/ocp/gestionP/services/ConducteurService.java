package ma.ocp.gestionP.services;

import ma.ocp.gestionP.dtos.ConducteurDTO;

import java.time.LocalDate;
import java.util.List;

public interface ConducteurService {
    ConducteurDTO saveConducteur(ConducteurDTO conducteurDTO);

    ConducteurDTO updateConducteur(Long id, ConducteurDTO conducteurDTO);

    void deleteConducteurById(Long id);

    List<ConducteurDTO> getAllConducteurs();

    long getConducteursCount();

    public ConducteurDTO getConducteurById(Long id);

    List<ConducteurDTO> getConducteursByNom(String nom);

    List<ConducteurDTO> getConducteursByDateEmbauche(LocalDate startDate, LocalDate endDate);

    public List<ConducteurDTO> getConducteursForVoyage(Long voyageId);
}
