package ma.ocp.gestionP.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConducteurDTO {
    private Long id;
    private String nom;
    private String prenom;
    private Date dateEm;
    private Double consommationCarburant;
    private Double vitesseMoyenne;
    private List<VoyageDTO> voyages; // Utilisation d'une liste pour les voyages
}

