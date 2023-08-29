package ma.ocp.gestionP.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Voyage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itineraire;
    private Date dateDepart;
    private Date dateArrivee;

    @ManyToMany
    @JoinTable(
            name = "voyage_conducteur",
            joinColumns = @JoinColumn(name = "voyage_id"),
            inverseJoinColumns = @JoinColumn(name = "conducteur_id")
    )
    @JsonIgnoreProperties("voyages")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Conducteur> conducteurs; // Liste des conducteurs associés à ce voyage

    @ManyToMany
    @JoinTable(
            name = "voyage_camion",
            joinColumns = @JoinColumn(name = "voyage_id"),
            inverseJoinColumns = @JoinColumn(name = "camion_id")
    )
    @JsonIgnoreProperties("voyages")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Camion> camions; // Liste des camions associés à ce voyage

    private double averageDuration;
    @ManyToOne
    @JoinColumn(name = "responsable_id")
    private ResponsableVoyages responsableVoyages;
}
