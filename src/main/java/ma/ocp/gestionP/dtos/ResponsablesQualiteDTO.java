package ma.ocp.gestionP.dtos;


import lombok.Data;
import ma.ocp.gestionP.entities.Qualite;

import java.util.List;


@Data
public class ResponsablesQualiteDTO {

    private long id;
    private String nom;
    private String pernom;
    private String usermane;
    private String password;
    private List<Qualite> qualites = new java.util.ArrayList<>();

}
