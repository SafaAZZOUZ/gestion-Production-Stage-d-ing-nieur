package ma.ocp.gestionP.security.repositories;
import ma.ocp.gestionP.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findAppUserByUsername(String username);
}
