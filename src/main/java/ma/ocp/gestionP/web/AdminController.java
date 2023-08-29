package ma.ocp.gestionP.web;
import ma.ocp.gestionP.dtos.AdminDTO;
import ma.ocp.gestionP.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
@CrossOrigin(origins = "*")
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminDTO> getAdminById(@PathVariable int id) {
        AdminDTO admin = adminService.getAdminById(id);
        return ResponseEntity.ok(admin);
    }

    @GetMapping("/login/{login}")
    public ResponseEntity<AdminDTO> getAdminByLogin(@PathVariable String login) {
        AdminDTO admin = adminService.getAdminByLogin(login);
        return ResponseEntity.ok(admin);
    }

    @GetMapping("/all")
    public ResponseEntity<List<AdminDTO>> getAllAdmins() {
        List<AdminDTO> admins = adminService.getAllAdmins();
        return ResponseEntity.ok(admins);
    }

}
