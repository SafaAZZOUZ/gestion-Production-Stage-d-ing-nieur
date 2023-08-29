package ma.ocp.gestionP.services;


import ma.ocp.gestionP.dtos.AdminDTO;
import ma.ocp.gestionP.entities.Admin;

import java.util.List;

public interface AdminService {
    AdminDTO getAdminById(int id);
    List<AdminDTO> getAllAdmins();
    AdminDTO getAdminByLogin(String login);
    Admin saveAdmin(Admin admin);
    void saveAdmin(AdminDTO adminDTO);
}
