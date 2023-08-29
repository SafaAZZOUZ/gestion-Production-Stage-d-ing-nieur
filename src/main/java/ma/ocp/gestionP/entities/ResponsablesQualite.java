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
public class ResponsablesQualite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String pernom;
    private String usermane;
    private String password;
    @OneToMany(mappedBy = "responsablesQualite")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Qualite> qualites = new java.util.ArrayList<>();
}
