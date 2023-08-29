package ma.ocp.gestionP.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Qualite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double tauxSatisfaction;
    private Double tauxDefauts;

    private LocalDateTime dateEvaluation;
    private String commentaires;

    @ManyToOne
    @JoinColumn(name = "responsable_id")
    private ResponsablesQualite responsablesQualite;
}
