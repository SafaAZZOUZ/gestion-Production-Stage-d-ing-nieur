package ma.ocp.gestionP.services;

import ma.ocp.gestionP.dtos.QualiteDTO;
import ma.ocp.gestionP.entities.Qualite;
import ma.ocp.gestionP.mappers.QualiteMapper;
import ma.ocp.gestionP.repositories.QualiteRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QualiteServiceImpl implements QualiteService {

    private  QualiteRepository qualiteRepository;
    private  QualiteMapper qualiteMapper;

    public QualiteServiceImpl(QualiteRepository qualiteRepository, QualiteMapper qualiteMapper) {
        this.qualiteRepository = qualiteRepository;
        this.qualiteMapper = qualiteMapper;
    }

    @Override
    public QualiteDTO saveQualite(QualiteDTO qualiteDTO) {
        Qualite qualite = qualiteMapper.toEntity(qualiteDTO);
        qualite = qualiteRepository.save(qualite);
        return qualiteMapper.toDto(qualite);
    }

    @Override
    public QualiteDTO updateQualite(Long id, QualiteDTO qualiteDTO) {
        Qualite existingQualite = qualiteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Qualite not found with id: " + id));
        Qualite qualite = qualiteMapper.toEntity(qualiteDTO);
        qualite.setId(existingQualite.getId());
        qualite= qualiteRepository.save(qualite);
        return qualiteMapper.toDto(qualite);

    }

    @Override
    public void deleteQualiteById(Long id) {
        qualiteRepository.deleteById(id);
    }

    @Override
    public List<QualiteDTO> getAllQualites() {
        List<Qualite> qualites = qualiteRepository.findAll();
        return qualites.stream()
                .map(qualiteMapper::toDto)
                .collect(Collectors.toList());
    }
    @Override
    public QualiteDTO getQualiteById(Long id) {
        Qualite qualite = qualiteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Qualite not found with id: " + id));

        return qualiteMapper.toDto(qualite);
    }
}
