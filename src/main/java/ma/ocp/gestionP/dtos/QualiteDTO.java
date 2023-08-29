package ma.ocp.gestionP.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QualiteDTO {
    private Long id;
    private Double tauxSatisfaction;
    private Double tauxDefauts;
    private LocalDateTime dateEvaluation;
    private String commentaires;

}

