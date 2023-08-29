package ma.ocp.gestionP.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CamionDTO {
    private Long id;
    private String marque;
    private String modele;
    private Double consommationCarburant;
    private Double kilometrage;
    private Date dateMaintenance;
    private List<VoyageDTO> voyages; // Utilisation d'une liste pour les voyages

}

