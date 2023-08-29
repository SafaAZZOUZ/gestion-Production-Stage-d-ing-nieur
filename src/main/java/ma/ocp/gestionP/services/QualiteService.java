package ma.ocp.gestionP.services;

import ma.ocp.gestionP.dtos.QualiteDTO;

import java.util.List;

public interface QualiteService {
    QualiteDTO saveQualite(QualiteDTO qualiteDTO);

    QualiteDTO updateQualite(Long id, QualiteDTO qualiteDTO);


    void deleteQualiteById(Long id);

    List<QualiteDTO> getAllQualites();

    QualiteDTO getQualiteById(Long id);
}
