package ma.ocp.gestionP.web;

import ma.ocp.gestionP.dtos.ResponsablesQualiteDTO;
import ma.ocp.gestionP.services.ResponsableQualiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ResponsableQ")
@CrossOrigin(origins = "*")
public class ResponsableQualiteController {
    private final ResponsableQualiteService responsableQualiteService;

    @Autowired
    public ResponsableQualiteController(ResponsableQualiteService responsableQualiteService) {
        this.responsableQualiteService = responsableQualiteService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponsablesQualiteDTO> getResponsablesQualiteById(@PathVariable int id) {
        ResponsablesQualiteDTO responsablesQualiteDTO = responsableQualiteService.getResposableById(id);
        return ResponseEntity.ok(responsablesQualiteDTO);
    }



    @GetMapping("/all")
    public ResponseEntity<List<ResponsablesQualiteDTO>> getAllAdmins() {
        List<ResponsablesQualiteDTO> responsables = responsableQualiteService.getResponsables();
        return ResponseEntity.ok(responsables);
    }
    @GetMapping("/username/{username}")
    public ResponseEntity<ResponsablesQualiteDTO> getEnseignantByUsername(@PathVariable String username) {
        ResponsablesQualiteDTO responsablesQualiteDTO = responsableQualiteService.getResponsablesByUsername(username);
        if (responsablesQualiteDTO != null) {
            return new ResponseEntity<>(responsablesQualiteDTO, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
