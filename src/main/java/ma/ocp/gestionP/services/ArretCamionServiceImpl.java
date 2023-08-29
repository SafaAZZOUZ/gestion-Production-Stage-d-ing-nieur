package ma.ocp.gestionP.services;

import ma.ocp.gestionP.dtos.ArretCamionDTO;
import ma.ocp.gestionP.dtos.CamionDTO;
import ma.ocp.gestionP.entities.ArretCamion;
import ma.ocp.gestionP.entities.Camion;
import ma.ocp.gestionP.mappers.ArretCamionMapper;
import ma.ocp.gestionP.mappers.CamionMapperImpl;
import ma.ocp.gestionP.repositories.ArretCamionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ArretCamionServiceImpl implements ArretCamionService {

    private ArretCamionRepository arretCamionRepository;
    private ArretCamionMapper arretCamionMapper;
    private CamionMapperImpl camionMapper;

    public ArretCamionServiceImpl(ArretCamionRepository arretCamionRepository, ArretCamionMapper arretCamionMapper) {
        this.arretCamionRepository = arretCamionRepository;
        this.arretCamionMapper = arretCamionMapper;
    }

    public ArretCamionDTO saveArretCamion(ArretCamionDTO arretCamionDTO) {
        ArretCamion arretCamion = arretCamionMapper.toEntity(arretCamionDTO);
        arretCamion = arretCamionRepository.save(arretCamion);
        return arretCamionMapper.toDto(arretCamion);
    }

    @Override
    public ArretCamionDTO updateArretCamion(Long id, ArretCamionDTO arretCamionDTO) {
        ArretCamion updatedArretCamion = arretCamionMapper.toEntity(arretCamionDTO);
        updatedArretCamion.setId(id);
        updatedArretCamion = arretCamionRepository.save(updatedArretCamion);
        return arretCamionMapper.toDto(updatedArretCamion);
    }


    public void deleteArretCamionById(Long id) {
        arretCamionRepository.deleteById(id);
    }

    public void deleteArretsByCamionId(Long camionId) {
        arretCamionRepository.deleteByCamionId(camionId);
    }

    public List<ArretCamionDTO> getAllArretsCamion() {
        List<ArretCamion> arretCamions = arretCamionRepository.findAll();
        return arretCamionMapper.toDtoList(arretCamions);
    }

    public long getArretsCamionCount() {
        return arretCamionRepository.count();
    }

    public boolean existsArretCamionById(Long id) {
        return arretCamionRepository.existsById(id);
    }

    public List<ArretCamionDTO> getArretsCamionSortedByDate() {
        List<ArretCamion> arretCamions = arretCamionRepository.findAllByOrderByDateHeureAsc();
        return arretCamionMapper.toDtoList(arretCamions);
    }

    public List<ArretCamionDTO> getArretsCamionInDateRange(LocalDateTime start, LocalDateTime end) {
        List<ArretCamion> arretCamions = arretCamionRepository.findAllByDateHeureBetween(start, end);
        return arretCamionMapper.toDtoList(arretCamions);
    }

    public ArretCamionDTO getArretCamionById(Long id) {
        Optional<ArretCamion> optionalArretCamion = arretCamionRepository.findById(id);
        return optionalArretCamion.map(arretCamionMapper::toDto).orElse(null);
    }
    @Override
    public CamionDTO getCamionOfArret(Long id) {
        Optional<ArretCamion> optionalArretCamion = arretCamionRepository.findById(id);

        if (optionalArretCamion.isPresent()) {
            ArretCamion arretCamion = optionalArretCamion.get();
            Camion camion = arretCamion.getCamion();

            if (camion != null) {
                return camionMapper.toDto(camion);
            }
        }

        return null;
    }
}
