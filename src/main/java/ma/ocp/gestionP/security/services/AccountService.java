package ma.ocp.gestionP.security.services;
import ma.ocp.gestionP.security.entities.AppRole;
import ma.ocp.gestionP.security.entities.AppUser;

import java.util.List;
public interface AccountService {
    AppUser addNewUser(AppUser appUser);
    AppRole addNewRole(AppRole appRole);
    void addRoleToUser(String username, String rolename);
    AppUser loadUserByUsername(String username);
    List<AppUser> listUsers();
    void deleteUserById(Long userId);
    AppUser updateUser(Long userId, AppUser updatedUser);
    AppUser getUserById(Long userId);
}
