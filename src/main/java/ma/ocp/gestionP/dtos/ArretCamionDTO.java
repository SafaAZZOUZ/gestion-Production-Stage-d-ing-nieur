package ma.ocp.gestionP.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArretCamionDTO {
    private Long id;
    private LocalDateTime dateHeure;
    private String cause;
    private String duree;
    private CamionDTO camion;

}

