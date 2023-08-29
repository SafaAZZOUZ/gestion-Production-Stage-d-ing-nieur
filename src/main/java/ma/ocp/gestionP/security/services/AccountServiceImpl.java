package ma.ocp.gestionP.security.services;
import ma.ocp.gestionP.security.entities.AppRole;
import ma.ocp.gestionP.security.entities.AppUser;
import ma.ocp.gestionP.security.repositories.AppRoleRepository;
import ma.ocp.gestionP.security.repositories.AppUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;
    private PasswordEncoder passwordEncoder;
    public AccountServiceImpl(AppUserRepository appUserRepository, AppRoleRepository appRoleRepository, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.appRoleRepository = appRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public AppUser addNewUser(AppUser appUser) {
        String pw = appUser.getPassword();
        appUser.setPassword(passwordEncoder.encode(pw));
        return appUserRepository.save(appUser);
    }
    @Override
    public AppRole addNewRole(AppRole appRole) {
        return appRoleRepository.save(appRole);
    }
    @Override
    public void addRoleToUser(String username, String rolename) {
        AppUser appUser = appUserRepository.findAppUserByUsername(username);
        AppRole appRole = appRoleRepository.findAppRoleByRoleName(rolename);
        appUser.getRoles().add(appRole);
        appUserRepository.save(appUser); // Enregistrer les modifications apportées à l'utilisateur
    }
    @Override
    public void deleteUserById(Long userId) {
        appUserRepository.deleteById(userId);
    }
    @Override
    public AppUser updateUser(Long userId, AppUser updatedUser) {
        AppUser existingUser = appUserRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
        existingUser.setEmail(updatedUser.getEmail());
        return appUserRepository.save(existingUser);
    }
    @Override
    public AppUser getUserById(Long userId) {
        return appUserRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepository.findAppUserByUsername(username);
    }
    @Override
    public List<AppUser> listUsers() {
        return appUserRepository.findAll();
    }
}
