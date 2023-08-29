package ma.ocp.gestionP.mappers;


import ma.ocp.gestionP.dtos.AdminDTO;
import ma.ocp.gestionP.entities.Admin;

public interface AdminMapper {
    AdminDTO adminToDTO(Admin admin);
    Admin DTOToAdmin(AdminDTO adminDTO);
}
