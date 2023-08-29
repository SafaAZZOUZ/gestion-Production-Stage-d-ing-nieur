package ma.ocp.gestionP.dtos;

import lombok.Data;
import ma.ocp.gestionP.entities.ArretCamion;
import ma.ocp.gestionP.entities.Camion;
import ma.ocp.gestionP.entities.Conducteur;
import ma.ocp.gestionP.entities.Voyage;

import java.util.List;

@Data
public class ResponsableVoyagesDTO {
    private long id;
    private String nom;
    private String pernom;
    private String usermane;
    private String password;
    private List<Camion> camions = new java.util.ArrayList<>();
    private List<Conducteur> conducteurs = new java.util.ArrayList<>();
    private List<ArretCamion> arretCamions  = new java.util.ArrayList<>();
    private List<Voyage>  voyages = new java.util.ArrayList<>();

}
