package ma.ocp.gestionP.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Conducteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private Date dateEm;
    private Double consommationCarburant;
    private Double vitesseMoyenne;
    @ManyToMany(mappedBy = "conducteurs")
    @JsonIgnoreProperties("conducteurs")
    private List<Voyage> voyages; // Liste des voyages associés à ce conducteur
    @ManyToOne
    @JoinColumn(name = "responsable_id")
    private ResponsableVoyages responsableVoyages;
}
