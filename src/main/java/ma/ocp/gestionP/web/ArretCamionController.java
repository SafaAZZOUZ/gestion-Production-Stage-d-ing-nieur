package ma.ocp.gestionP.web;

import lombok.AllArgsConstructor;
import ma.ocp.gestionP.dtos.ArretCamionDTO;
import ma.ocp.gestionP.dtos.CamionDTO;
import ma.ocp.gestionP.services.ArretCamionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/arrets-camion")
@CrossOrigin("*")
@AllArgsConstructor
public class ArretCamionController {

    private final ArretCamionService arretCamionService;



    @PostMapping
    public ResponseEntity<ArretCamionDTO> saveArretCamion(@RequestBody ArretCamionDTO arretCamionDTO) {
        ArretCamionDTO savedArretCamion = arretCamionService.saveArretCamion(arretCamionDTO);
        return new ResponseEntity<>(savedArretCamion, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArretCamionDTO> updateArretCamion(@PathVariable Long id, @RequestBody ArretCamionDTO arretCamionDTO) {
        ArretCamionDTO updatedArretCamion = arretCamionService.updateArretCamion(id, arretCamionDTO);
        return ResponseEntity.ok(updatedArretCamion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArretCamion(@PathVariable Long id) {
        arretCamionService.deleteArretCamionById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ArretCamionDTO>> getAllArretsCamion() {
        List<ArretCamionDTO> arretsCamion = arretCamionService.getAllArretsCamion();
        return ResponseEntity.ok(arretsCamion);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getArretsCamionCount() {
        long count = arretCamionService.getArretsCamionCount();
        return ResponseEntity.ok(count);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArretCamionDTO> getArretCamionById(@PathVariable Long id) {
        ArretCamionDTO arretCamion = arretCamionService.getArretCamionById(id);
        if (arretCamion == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(arretCamion);
    }

    @GetMapping("/{id}/camion")
    public ResponseEntity<CamionDTO> getCamionOfArret(@PathVariable Long id) {
        ArretCamionDTO arretCamion = arretCamionService.getArretCamionById(id);

        if (arretCamion == null) {
            return ResponseEntity.notFound().build();
        }

        CamionDTO camionDuArret = arretCamion.getCamion();

        if (camionDuArret == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(camionDuArret);
    }


}
