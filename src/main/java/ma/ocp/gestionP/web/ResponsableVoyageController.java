package ma.ocp.gestionP.web;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ma.ocp.gestionP.dtos.ResponsableVoyagesDTO;
import ma.ocp.gestionP.services.ResponsableVoyageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ResponsableV")
@CrossOrigin(origins = "*")
@AllArgsConstructor
@NoArgsConstructor
public class ResponsableVoyageController {

    private  ResponsableVoyageService responsableVoyageService;


    @GetMapping("/{id}")
    public ResponseEntity<ResponsableVoyagesDTO> getResponsablesVoyageById(@PathVariable int id) {
        ResponsableVoyagesDTO responsableVoyagesDTO = responsableVoyageService.getResposableById(id);
        return ResponseEntity.ok(responsableVoyagesDTO);
    }


    @GetMapping("/all")
    public ResponseEntity<List<ResponsableVoyagesDTO>> getAllAdmins() {
        List<ResponsableVoyagesDTO> responsables = responsableVoyageService.getResponsables();
        return ResponseEntity.ok(responsables);
    }
    @GetMapping("/username/{username}")
    public ResponseEntity<ResponsableVoyagesDTO> getEnseignantByUsername(@PathVariable String username) {
        ResponsableVoyagesDTO responsableVoyagesDTO = responsableVoyageService.getResponsablesByUsername(username);
        if (responsableVoyagesDTO != null) {
            return new ResponseEntity<>(responsableVoyagesDTO, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
