package ma.ocp.gestionP.services;

import ma.ocp.gestionP.dtos.ResponsableVoyagesDTO;
import ma.ocp.gestionP.entities.ResponsableVoyages;
import ma.ocp.gestionP.mappers.ResponsableVoyageMapper;
import ma.ocp.gestionP.repositories.ResponsableVoyagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponsableVoyageServiceImpl implements ResponsableVoyageService {

    private ResponsableVoyagesRepository responsableVoyagesRepository;
    private ResponsableVoyageMapper responsableVoyageMapper;

    @Autowired
    public ResponsableVoyageServiceImpl(ResponsableVoyagesRepository responsableVoyagesRepository,
                                        ResponsableVoyageMapper responsableVoyageMapper) {
        this.responsableVoyagesRepository = responsableVoyagesRepository;
        this.responsableVoyageMapper = responsableVoyageMapper;
    }

    @Override
    public ResponsableVoyagesDTO getResposableById(int id) {
        ResponsableVoyages responsableVoyages = responsableVoyagesRepository.findById((long) id)
                .orElseThrow(()-> new IllegalArgumentException("invalid"));
        return responsableVoyageMapper.ToDTO(responsableVoyages);

    }
    @Override
    public List<ResponsableVoyagesDTO> getResponsables() {
        List<ResponsableVoyages> responsableVoyagesList = responsableVoyagesRepository.findAll();
        List<ResponsableVoyagesDTO> responsableVoyagesDTOS =null;
        for (ResponsableVoyages responsableVoyages : responsableVoyagesList){
            responsableVoyagesDTOS.add(responsableVoyageMapper.ToDTO(responsableVoyages));
        }
        return responsableVoyagesDTOS;
    }

    @Override
    public ResponsableVoyagesDTO getResponsablesByUsername(String username) {
        ResponsableVoyages responsableVoyages = responsableVoyagesRepository.findByUsermane(username);
        return responsableVoyageMapper.ToDTO(responsableVoyages);
    }

    @Override
    public ResponsableVoyages saveResponsable(ResponsableVoyages responsablesVoyage) {
        return responsableVoyagesRepository.save(responsablesVoyage);
    }

    @Override
    public void saveResponsable(ResponsableVoyagesDTO responsablesVoyageDTO) {
        ResponsableVoyages responsableVoyages = responsableVoyageMapper.DTOTo(responsablesVoyageDTO);
        responsableVoyagesRepository.save(responsableVoyages);
    }
}
