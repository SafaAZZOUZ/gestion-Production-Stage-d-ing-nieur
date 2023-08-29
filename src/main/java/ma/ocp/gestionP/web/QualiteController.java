package ma.ocp.gestionP.web;

import lombok.AllArgsConstructor;
import ma.ocp.gestionP.dtos.QualiteDTO;
import ma.ocp.gestionP.services.QualiteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/qualites")
@CrossOrigin("*")
@AllArgsConstructor
public class QualiteController {

    private final QualiteService qualiteService;



    @PostMapping
    public ResponseEntity<QualiteDTO> saveQualite(@RequestBody QualiteDTO qualiteDTO) {
        QualiteDTO savedQualite = qualiteService.saveQualite(qualiteDTO);
        return new ResponseEntity<>(savedQualite, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QualiteDTO> updateQualite(@PathVariable Long id, @RequestBody QualiteDTO qualiteDTO) {
        QualiteDTO updatedQualite = qualiteService.updateQualite(id, qualiteDTO);
        return ResponseEntity.ok(updatedQualite);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQualite(@PathVariable Long id) {
        qualiteService.deleteQualiteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<QualiteDTO>> getAllQualites() {
        List<QualiteDTO> qualites = qualiteService.getAllQualites();
        return ResponseEntity.ok(qualites);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QualiteDTO> getQualiteById(@PathVariable Long id) {
        QualiteDTO qualite = qualiteService.getQualiteById(id);
        return ResponseEntity.ok(qualite);
    }
}
