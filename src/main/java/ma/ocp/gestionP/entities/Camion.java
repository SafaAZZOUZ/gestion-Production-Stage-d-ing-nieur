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
public class Camion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marque;
    private String modele;
    private Double kilometrage;
    private Double consommationCarburant;
    private Date dateMaintenance;
    @ManyToMany(mappedBy = "camions")
    @JsonIgnoreProperties("camions")
    private List<Voyage> voyages; // Liste des voyages associés à ce camion
    @ManyToOne
    @JoinColumn(name = "responsable_id")
    private ResponsableVoyages responsableVoyages;
}
