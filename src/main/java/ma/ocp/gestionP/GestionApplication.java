package ma.ocp.gestionP;

import ma.ocp.gestionP.security.entities.AppRole;
import ma.ocp.gestionP.security.entities.AppUser;
import ma.ocp.gestionP.security.services.AccountService;

import ma.ocp.gestionP.dtos.*;

import ma.ocp.gestionP.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.*;
import java.util.stream.Stream;


@SpringBootApplication
public class GestionApplication {
    public GestionApplication() {
    }

    public static void main(String[] args) {
        SpringApplication.run(GestionApplication.class, args);
    }
    //@Bean
    CommandLineRunner commandLineRunner(ResponsableVoyageService responsableVoyageService,
                                        ResponsableQualiteService responsableQualiteService,
                                        AdminService adminService,
                                        AccountService accountService) {
        return (args) -> {
            final int[] i = {1};
            Stream.of("admin").forEach(login -> {
                AdminDTO adminDTO = new AdminDTO();
                adminDTO.setId(i[0]);
                adminDTO.setLogin(login);
                adminDTO.setPassword(login + UUID.randomUUID());
                adminService.saveAdmin(adminDTO);
                i[0]++; // Increment the ID for the next admin
            });
            accountService.addNewRole(new AppRole(null, "ADMIN"));
            accountService.addNewRole(new AppRole(null, "ResponsableVoyages"));
            accountService.addNewRole(new AppRole(null, "ResponsablesQualite"));

            accountService.addNewUser(new AppUser(null, "admin", "admin@gmail.com","admin", new ArrayList<>()));
            accountService.addNewUser(new AppUser(null, "safa","safa@gmail.com","1111", new ArrayList<>()));
            accountService.addNewUser(new AppUser(null, "azzouz", "azzouz@gmail.com","1111", new ArrayList<>()));

            accountService.addRoleToUser("admin", "ADMIN");
            accountService.addRoleToUser("safa", "ResponsableVoyages");
            accountService.addRoleToUser("azzouz", "ResponsablesQualite");

            Stream.of("safa").forEach(name -> {
                ResponsableVoyagesDTO responsableVoyagesDTO = new ResponsableVoyagesDTO();
                responsableVoyagesDTO.setNom(name);
                responsableVoyagesDTO.setUsermane(name);
                responsableVoyageService.saveResponsable(responsableVoyagesDTO);
            });
            Stream.of("azzouz").forEach(name -> {
                ResponsablesQualiteDTO responsablesQualiteDTO = new ResponsablesQualiteDTO();
                responsablesQualiteDTO.setNom(name);
                responsablesQualiteDTO.setUsermane(name);
                responsableQualiteService.saveResponsable(responsablesQualiteDTO);
            });
            AdminDTO adminDTO = new AdminDTO();
            adminDTO.setLogin("admin");
            adminDTO.setPassword("admin");
        };
    }



    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
