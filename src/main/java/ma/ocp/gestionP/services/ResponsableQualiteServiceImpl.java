package ma.ocp.gestionP.services;

import ma.ocp.gestionP.dtos.ResponsablesQualiteDTO;
import ma.ocp.gestionP.entities.ResponsablesQualite;
import ma.ocp.gestionP.mappers.ResponsableQualiteMapper;
import ma.ocp.gestionP.repositories.ResponsableQualiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ResponsableQualiteServiceImpl implements ResponsableQualiteService {

    private  ResponsableQualiteRepository responsableQualiteRepository;
    private  ResponsableQualiteMapper responsableQualiteMapper;

    @Autowired
    public ResponsableQualiteServiceImpl(ResponsableQualiteRepository responsableQualiteRepository, ResponsableQualiteMapper responsableQualiteMapper) {
        this.responsableQualiteRepository = responsableQualiteRepository;
        this.responsableQualiteMapper = responsableQualiteMapper;
    }

    @Override
    public ResponsablesQualiteDTO getResposableById(int id) {
        ResponsablesQualite responsablesQualite = responsableQualiteRepository.findById((long) id)
                .orElseThrow(()-> new IllegalArgumentException("invalid"));
        return responsableQualiteMapper.ToDTO(responsablesQualite);

    }

    @Override
    public List<ResponsablesQualiteDTO> getResponsables() {
        List<ResponsablesQualite> responsablesQualiteList = responsableQualiteRepository.findAll();
        List<ResponsablesQualiteDTO> responsablesQualiteDTOS =null;
        for (ResponsablesQualite responsablesQualite : responsablesQualiteList){
            responsablesQualiteDTOS.add(responsableQualiteMapper.ToDTO(responsablesQualite));
        }
        return responsablesQualiteDTOS;
    }


    @Override
    public ResponsablesQualite saveResponsable(ResponsablesQualite responsablesQualite) {
        return responsableQualiteRepository.save(responsablesQualite);
    }

    @Override
    public void saveResponsable(ResponsablesQualiteDTO responsablesQualiteDTO) {
        ResponsablesQualite responsablesQualite = responsableQualiteMapper.DTOTo(responsablesQualiteDTO);
        responsableQualiteRepository.save(responsablesQualite);
    }
    @Override
    public ResponsablesQualiteDTO getResponsablesByUsername(String username) {
        ResponsablesQualite responsablesQualite = responsableQualiteRepository.findByUsermane(username);
        return responsableQualiteMapper.ToDTO(responsablesQualite);
    }
}
