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
public class ArretCamion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateHeure;
    private String cause;
    private String duree;

    @ManyToOne
    @JoinColumn(name = "camion_id")
    private Camion camion;

    @ManyToOne
    @JoinColumn(name = "responsable_id")
    private ResponsableVoyages responsableVoyages;
}


