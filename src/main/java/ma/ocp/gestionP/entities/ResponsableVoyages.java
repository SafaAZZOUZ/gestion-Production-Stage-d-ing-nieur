package ma.ocp.gestionP.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponsableVoyages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String pernom;
    private String usermane;
    private String password;

    @OneToMany(mappedBy = "responsableVoyages")  // Correction ici
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Camion> camions = new java.util.ArrayList<>();

    @OneToMany(mappedBy = "responsableVoyages")  // Correction ici
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Conducteur> conducteurs = new java.util.ArrayList<>();

    @OneToMany(mappedBy = "responsableVoyages")  // Correction ici
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<ArretCamion> arretCamions = new java.util.ArrayList<>();

    @OneToMany(mappedBy = "responsableVoyages")  // Correction ici
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Voyage> voyages = new java.util.ArrayList<>();
}
