package ma.ocp.gestionP.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoyageDTO {
    private Long id;
    private String itineraire;
    private Date dateDepart;
    private Date dateArrivee;
    private List<CamionDTO> camions;
    private List<ConducteurDTO> conducteurs;
    private double averageDuration;
}

