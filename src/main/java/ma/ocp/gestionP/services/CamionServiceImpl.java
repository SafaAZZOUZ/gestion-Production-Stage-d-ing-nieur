package ma.ocp.gestionP.services;

import ma.ocp.gestionP.dtos.CamionDTO;
import ma.ocp.gestionP.entities.Camion;
import ma.ocp.gestionP.mappers.CamionMapper;
import ma.ocp.gestionP.repositories.CamionRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CamionServiceImpl implements CamionService {

    private  CamionRepository camionRepository;
    private  CamionMapper camionMapper;

    public CamionServiceImpl(CamionRepository camionRepository, CamionMapper camionMapper) {
        this.camionRepository = camionRepository;
        this.camionMapper = camionMapper;
    }

    @Override
    public CamionDTO saveCamion(CamionDTO camionDTO) {
        Camion camion = camionMapper.toEntity(camionDTO);
        camion = camionRepository.save(camion);
        return camionMapper.toDto(camion);
    }

    @Override
    public List<CamionDTO> getCamionsForVoyage(Long voyageId) {
        List<Camion> camions = camionRepository.findByVoyages_Id(voyageId);
        return camionMapper.toDtoList(camions); // Convertir en DTOs avant de renvoyer
    }

    @Override
    public CamionDTO updateCamion(Long id, CamionDTO camionDTO) {

        Camion existingCamion = camionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Camion with ID " + id + " not found"));

        Camion camion = camionMapper.toEntity(camionDTO);
        camion.setId(existingCamion.getId()); // Assurez-vous de mettre à jour l'ID
        camion.setConsommationCarburant(existingCamion.getConsommationCarburant()); // Mettre à jour la consommation de carburant
        camion = camionRepository.save(camion);
        return camionMapper.toDto(camion);
    }

    @Override
    public void deleteCamionById(Long id) {
        camionRepository.deleteById(id);
    }

    @Override
    public List<CamionDTO> getAllCamions() {
        List<Camion> camions = camionRepository.findAll();
        return camionMapper.toDtoList(camions);
    }

    @Override
    public long getCamionsCount() {
        return camionRepository.count();
    }


    @Override
    public CamionDTO getCamionById(Long id) {
        Optional<Camion> camionOptional = camionRepository.findById(id);
        return camionOptional.map(camionMapper::toDto).orElse(null);
    }

    @Override
    public List<CamionDTO> getCamionsByMarque(String marque) {
        List<Camion> camions = camionRepository.findByMarque(marque);
        return camionMapper.toDtoList(camions);
    }

    @Override
    public List<CamionDTO> getCamionsByVoyageDate(Date startDate) {
        List<Camion> camions = camionRepository.findAllByVoyages_DateDepart(startDate);
        return camionMapper.toDtoList(camions);
    }

}
