package ma.ocp.gestionP.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DonneesDeReporting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "voyage_id")
    private Voyage voyage;

    @ManyToOne
    @JoinColumn(name = "qualite_id")
    private Qualite qualite;

    @ManyToOne
    @JoinColumn(name = "arret_camion_id")
    private ArretCamion arretCamion;

    @ManyToOne
    @JoinColumn(name = "conducteur_id")
    private Conducteur conducteur;

    @ManyToOne
    @JoinColumn(name = "camion_id")
    private Camion camion;


}
