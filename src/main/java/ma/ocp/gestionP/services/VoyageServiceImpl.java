package ma.ocp.gestionP.services;

import ma.ocp.gestionP.dtos.DataByMonthYearDTO;
import ma.ocp.gestionP.dtos.VoyageDTO;
import ma.ocp.gestionP.entities.DataByMonthYear;
import ma.ocp.gestionP.entities.Voyage;
import ma.ocp.gestionP.mappers.VoyageMapper;
import ma.ocp.gestionP.repositories.DataByMonthYearRepository;
import ma.ocp.gestionP.repositories.VoyageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VoyageServiceImpl implements VoyageService {

    private  VoyageRepository voyageRepository;
    private  VoyageMapper voyageMapper;
    @Autowired
    private DataByMonthYearRepository dataByMonthYearRepository;

    public VoyageServiceImpl(VoyageRepository voyageRepository, VoyageMapper voyageMapper) {
        this.voyageRepository = voyageRepository;
        this.voyageMapper = voyageMapper;
    }

    @Override
    public VoyageDTO saveVoyage(VoyageDTO voyageDTO) {
        Voyage voyage = voyageMapper.toEntity(voyageDTO);
        voyage = voyageRepository.save(voyage);
        return voyageMapper.toDto(voyage);
    }


    @Override
    public VoyageDTO updateVoyage(Long id, VoyageDTO voyageDTO) {
        Voyage existingVoyage = voyageRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Voyage not found with id: " + id));
        existingVoyage.setItineraire(voyageDTO.getItineraire());
        existingVoyage.setDateDepart(voyageDTO.getDateDepart());
        existingVoyage.setDateArrivee(voyageDTO.getDateArrivee());

        existingVoyage = voyageRepository.save(existingVoyage);
        return voyageMapper.toDto(existingVoyage);
    }

    @Override
    public void deleteVoyageById(Long id) {
        voyageRepository.deleteById(id);
    }

    @Override
    public List<VoyageDTO> getAllVoyages() {
        List<Voyage> voyages = voyageRepository.findAll();
        return voyageMapper.toDtoList(voyages);
    }

    @Override
    public long getVoyagesCount() {
        return voyageRepository.count();
    }

    @Override
    public VoyageDTO getVoyageById(Long id) {
        Optional<Voyage> voyageOptional = voyageRepository.findById(id);
        return voyageOptional.map(voyageMapper::toDto).orElse(null);
    }

    @Override
    public List<VoyageDTO> getVoyagesByDate(LocalDate date) {
        List<Voyage> voyages = voyageRepository.findByDateDepart(date);
        return voyageMapper.toDtoList(voyages);
    }

    @Override
    public List<VoyageDTO> getVoyagesByConducteur(Long conducteurId) {
        List<Voyage> voyages = voyageRepository.findByConducteurs_Id(conducteurId);
        return voyageMapper.toDtoList(voyages);
    }

    @Override
    public List<VoyageDTO> getVoyagesByCamion(Long camionId) {
        List<Voyage> voyages = voyageRepository.findByCamions_Id(camionId);
        return voyageMapper.toDtoList(voyages);
    }
    public Duration calculateTotalTravelTime() {
        List<Voyage> voyages = voyageRepository.findAll();
        Duration totalTravelTime = Duration.ZERO;

        for (Voyage voyage : voyages) {
            Duration voyageTravelTime = Duration.between(voyage.getDateDepart().toInstant(), voyage.getDateArrivee().toInstant());
            totalTravelTime = totalTravelTime.plus(voyageTravelTime);
        }

        return totalTravelTime;
    }
    @Override
    public List<DataByMonthYearDTO> getVoyagesByMonthYear() {
        List<DataByMonthYear> dataByMonthYears = dataByMonthYearRepository.findAll();
        List<DataByMonthYearDTO> result = new ArrayList<>();

        for (DataByMonthYear data : dataByMonthYears) {
            String monthYear = data.getMonthYear();
            int numberOfVoyages = data.getNumberOfVoyages();

            DataByMonthYearDTO dto = new DataByMonthYearDTO(monthYear, numberOfVoyages);
            result.add(dto);
        }

        return result;
    }
    public List<VoyageDTO> calculateAverageDuration() {
        List<Voyage> voyages = voyageRepository.findAll();
        List<VoyageDTO> averageDurations = new ArrayList<>();

        // Calculer la durée moyenne pour chaque voyage
        for (Voyage voyage : voyages) {
            VoyageDTO voyageDTO = voyageMapper.toDto(voyage);
            long voyageDuration = voyage.getDateArrivee().getTime() - voyage.getDateDepart().getTime();
            double averageDurationInHours = (double) voyageDuration / (1000 * 60 * 60);
            voyageDTO.setAverageDuration(averageDurationInHours);
            averageDurations.add(voyageDTO);
        }

        return averageDurations;
    }
}
