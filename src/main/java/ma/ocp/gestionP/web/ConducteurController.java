package ma.ocp.gestionP.web;
import lombok.AllArgsConstructor;
import ma.ocp.gestionP.dtos.ConducteurDTO;
import ma.ocp.gestionP.services.ConducteurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/conducteurs")
@CrossOrigin("*")
@AllArgsConstructor
public class ConducteurController {

    private final ConducteurService conducteurService;


    @PostMapping
    public ResponseEntity<ConducteurDTO> saveConducteur(@RequestBody ConducteurDTO conducteurDTO) {
        ConducteurDTO savedConducteur = conducteurService.saveConducteur(conducteurDTO);
        return new ResponseEntity<>(savedConducteur, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConducteurDTO> updateConducteur(@PathVariable Long id, @RequestBody ConducteurDTO conducteurDTO) {
        ConducteurDTO updatedConducteur = conducteurService.updateConducteur(id, conducteurDTO);
        return ResponseEntity.ok(updatedConducteur);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConducteur(@PathVariable Long id) {
        conducteurService.deleteConducteurById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ConducteurDTO>> getAllConducteurs() {
        List<ConducteurDTO> conducteurs = conducteurService.getAllConducteurs();
        return ResponseEntity.ok(conducteurs);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getConducteursCount() {
        long count = conducteurService.getConducteursCount();
        return ResponseEntity.ok(count);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConducteurDTO> getConducteurById(@PathVariable Long id) {
        ConducteurDTO conducteur = conducteurService.getConducteurById(id);
        if (conducteur == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(conducteur);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ConducteurDTO>> searchConducteursByNom(@RequestParam String nom) {
        List<ConducteurDTO> conducteurs = conducteurService.getConducteursByNom(nom);
        return ResponseEntity.ok(conducteurs);
    }

    @GetMapping("/searchByDateEmbauche")
    public ResponseEntity<List<ConducteurDTO>> searchConducteursByDateEmbauche(
            @RequestParam String startDate, @RequestParam String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        List<ConducteurDTO> conducteurs = conducteurService.getConducteursByDateEmbauche(start, end);
        return ResponseEntity.ok(conducteurs);
    }
}
