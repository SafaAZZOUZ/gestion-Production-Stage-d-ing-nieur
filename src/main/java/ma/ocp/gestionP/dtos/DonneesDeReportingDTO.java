package ma.ocp.gestionP.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DonneesDeReportingDTO {
    private Long id;
    private VoyageDTO voyage;
    private QualiteDTO qualite;
    private ArretCamionDTO arretCamion;
    private ConducteurDTO conducteur;
    private CamionDTO camion;

}
