package ma.ocp.gestionP.security.repositories;
import ma.ocp.gestionP.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
    AppRole findAppRoleByRoleName(String username);
}
