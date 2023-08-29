package ma.ocp.gestionP.dtos;


import lombok.Data;

@Data
public class AdminDTO {

    private long id;
    private String login;
    private String password;
}
