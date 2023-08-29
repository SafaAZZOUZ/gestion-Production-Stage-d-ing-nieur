package ma.ocp.gestionP.services;

import ma.ocp.gestionP.dtos.DataByMonthYearDTO;
import ma.ocp.gestionP.dtos.VoyageDTO;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

public interface VoyageService {
    VoyageDTO saveVoyage(VoyageDTO voyageDTO);


    void deleteVoyageById(Long id);

    List<VoyageDTO> getAllVoyages();

    long getVoyagesCount();

    Duration calculateTotalTravelTime();

    public VoyageDTO getVoyageById(Long id);

    List<VoyageDTO> getVoyagesByDate(LocalDate date);

    List<VoyageDTO> getVoyagesByConducteur(Long conducteurId);

    List<VoyageDTO> getVoyagesByCamion(Long camionId);
    public VoyageDTO updateVoyage(Long id, VoyageDTO voyageDTO);
    public List<DataByMonthYearDTO> getVoyagesByMonthYear();
    public List<VoyageDTO> calculateAverageDuration();

}
