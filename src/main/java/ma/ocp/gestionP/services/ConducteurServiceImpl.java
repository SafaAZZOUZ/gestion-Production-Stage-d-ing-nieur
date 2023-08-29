package ma.ocp.gestionP.services;

import ma.ocp.gestionP.dtos.ConducteurDTO;
import ma.ocp.gestionP.entities.Conducteur;
import ma.ocp.gestionP.mappers.ConducteurMapper;
import ma.ocp.gestionP.repositories.ConducteurRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ConducteurServiceImpl implements ConducteurService {

    private final ConducteurRepository conducteurRepository;
    private final ConducteurMapper conducteurMapper;

    public ConducteurServiceImpl(ConducteurRepository conducteurRepository, ConducteurMapper conducteurMapper) {
        this.conducteurRepository = conducteurRepository;
        this.conducteurMapper = conducteurMapper;
    }

    @Override
    public ConducteurDTO saveConducteur(ConducteurDTO conducteurDTO) {
        Conducteur conducteur = conducteurMapper.toEntity(conducteurDTO);
        conducteur = conducteurRepository.save(conducteur);
        return conducteurMapper.toDto(conducteur);
    }

    @Override
    public List<ConducteurDTO> getConducteursForVoyage(Long voyageId) {
        List<Conducteur> conducteurs = conducteurRepository.findByVoyagesId(voyageId);
        return conducteurMapper.toDtoList(conducteurs); // Convertir en DTOs avant de renvoyer
    }

    @Override
    public ConducteurDTO updateConducteur(Long id, ConducteurDTO conducteurDTO) {
        Conducteur existingConducteur = conducteurRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Conducteur not found with id: " + id));

        Conducteur conducteur = conducteurMapper.toEntity(conducteurDTO);
        conducteur.setId(existingConducteur.getId()); // Assurez-vous que l'ID est préservé
        conducteur = conducteurRepository.save(conducteur);
        return conducteurMapper.toDto(conducteur);
    }

    @Override
    public void deleteConducteurById(Long id) {
        conducteurRepository.deleteById(id);
    }

    @Override
    public List<ConducteurDTO> getAllConducteurs() {
        List<Conducteur> conducteurs = conducteurRepository.findAll();
        return conducteurMapper.toDtoList(conducteurs);
    }

    @Override
    public long getConducteursCount() {
        return conducteurRepository.count();
    }

    @Override
    public ConducteurDTO getConducteurById(Long id) {
        Optional<Conducteur> conducteurOptional = conducteurRepository.findById(id);

        if (conducteurOptional.isPresent()) {
            Conducteur conducteur = conducteurOptional.get();
            return conducteurMapper.toDto(conducteur);
        } else {
            return null;
        }
    }

    @Override
    public List<ConducteurDTO> getConducteursByNom(String nom) {
        List<Conducteur> conducteurs = conducteurRepository.findByNom(nom);
        return conducteurMapper.toDtoList(conducteurs);
    }

    @Override
    public List<ConducteurDTO> getConducteursByDateEmbauche(LocalDate startDate, LocalDate endDate) {
        List<Conducteur> conducteurs = conducteurRepository.findAllByDateEmBetween(startDate, endDate);
        return conducteurMapper.toDtoList(conducteurs);
    }
}
