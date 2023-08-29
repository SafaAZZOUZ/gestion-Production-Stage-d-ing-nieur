package ma.ocp.gestionP.web;

import lombok.AllArgsConstructor;
import ma.ocp.gestionP.dtos.CamionDTO;
import ma.ocp.gestionP.services.CamionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/camions")
@CrossOrigin("*")
@AllArgsConstructor
public class CamionController {

    private final CamionService camionService;


    @PostMapping
    public ResponseEntity<CamionDTO> saveCamion(@RequestBody CamionDTO camionDTO) {
        CamionDTO savedCamion = camionService.saveCamion(camionDTO);
        return new ResponseEntity<>(savedCamion, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CamionDTO> updateCamion(@PathVariable Long id, @RequestBody CamionDTO camionDTO) {
        CamionDTO updatedCamion = camionService.updateCamion(id, camionDTO);
        return ResponseEntity.ok(updatedCamion);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCamion(@PathVariable Long id) {
        camionService.deleteCamionById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<CamionDTO>> getAllCamions() {
        List<CamionDTO> camions = camionService.getAllCamions();
        return ResponseEntity.ok(camions);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getCamionsCount() {
        long count = camionService.getCamionsCount();
        return ResponseEntity.ok(count);
    }

    @GetMapping("/by-marque/{marque}")
    public ResponseEntity<List<CamionDTO>> getCamionsByMarque(@PathVariable String marque) {
        List<CamionDTO> camions = camionService.getCamionsByMarque(marque);
        return ResponseEntity.ok(camions);
    }

    @GetMapping("/by-voyage-date")
    public ResponseEntity<List<CamionDTO>> getCamionsByVoyageDate(
            @RequestParam("start") Date startDate) {
        List<CamionDTO> camions = camionService.getCamionsByVoyageDate(startDate);
        return ResponseEntity.ok(camions);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CamionDTO> getCamionById(@PathVariable Long id) {
        CamionDTO camion = camionService.getCamionById(id);
        if (camion == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(camion);
    }


}
