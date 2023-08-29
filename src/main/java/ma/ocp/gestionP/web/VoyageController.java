package ma.ocp.gestionP.web;

import lombok.AllArgsConstructor;
import ma.ocp.gestionP.dtos.CamionDTO;
import ma.ocp.gestionP.dtos.ConducteurDTO;
import ma.ocp.gestionP.dtos.DataByMonthYearDTO;
import ma.ocp.gestionP.dtos.VoyageDTO;
import ma.ocp.gestionP.services.CamionService;
import ma.ocp.gestionP.services.ConducteurService;
import ma.ocp.gestionP.services.VoyageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/voyages")
@CrossOrigin("*")
@AllArgsConstructor
public class VoyageController {

    private final VoyageService voyageService;
    private final CamionService camionService;
    private final ConducteurService conducteurService;

    @PostMapping
    public ResponseEntity<VoyageDTO> saveVoyage(@RequestBody VoyageDTO voyageDTO) {
        VoyageDTO savedVoyage = voyageService.saveVoyage(voyageDTO);
        return new ResponseEntity<>(savedVoyage, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VoyageDTO> updateVoyage(@PathVariable Long id, @RequestBody VoyageDTO voyageDTO) {
        VoyageDTO updatedVoyage = voyageService.updateVoyage(id, voyageDTO);
        return ResponseEntity.ok(updatedVoyage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVoyage(@PathVariable Long id) {
        voyageService.deleteVoyageById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<VoyageDTO>> getAllVoyages() {
        List<VoyageDTO> voyages = voyageService.getAllVoyages();
        return ResponseEntity.ok(voyages);
    }


    @GetMapping("/count")
    public ResponseEntity<Long> getVoyagesCount() {
        long count = voyageService.getVoyagesCount();
        return ResponseEntity.ok(count);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VoyageDTO> getVoyageById(@PathVariable Long id) {
        VoyageDTO voyage = voyageService.getVoyageById(id);
        if (voyage == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(voyage);
    }

    @GetMapping("/by-date")
    public ResponseEntity<List<VoyageDTO>> getVoyagesByDate(@RequestParam LocalDate date) {
        List<VoyageDTO> voyages = voyageService.getVoyagesByDate(date);
        return ResponseEntity.ok(voyages);
    }

    @GetMapping("/by-conducteur")
    public ResponseEntity<List<VoyageDTO>> getVoyagesByConducteur(@RequestParam Long conducteurId) {
        List<VoyageDTO> voyages = voyageService.getVoyagesByConducteur(conducteurId);
        return ResponseEntity.ok(voyages);
    }

    @GetMapping("/by-camion")
    public ResponseEntity<List<VoyageDTO>> getVoyagesByCamion(@RequestParam Long camionId) {
        List<VoyageDTO> voyages = voyageService.getVoyagesByCamion(camionId);
        return ResponseEntity.ok(voyages);
    }
    @GetMapping("/total-travel-time")
    public ResponseEntity<Map<String, String>> getTotalTravelTime() {
        Duration totalTravelTime = voyageService.calculateTotalTravelTime();
        long hours = totalTravelTime.toHours();
        long minutes = totalTravelTime.toMinutesPart();
        String formattedTime = String.format("%02d:%02d", hours, minutes);

        Map<String, String> response = new HashMap<>();
        response.put("totalTravelTime", formattedTime);

        return ResponseEntity.ok(response);
    }
    @GetMapping("/by-month-year")
    public ResponseEntity<List<DataByMonthYearDTO>> getVoyagesByMonthYear() {
        List<DataByMonthYearDTO> data = voyageService.getVoyagesByMonthYear();
        return ResponseEntity.ok(data);
    }
    @GetMapping("/average-duration")
    public ResponseEntity<List<VoyageDTO>> getAverageDuration() {
        List<VoyageDTO> averageDurations = voyageService.calculateAverageDuration();
        return ResponseEntity.ok(averageDurations);
    }
    @GetMapping("/{id}/camions")
    public ResponseEntity<List<CamionDTO>> getCamionsForVoyage(@PathVariable Long id) {
        List<CamionDTO> camions = camionService.getCamionsForVoyage(id);

        if (camions.isEmpty()) {
            return ResponseEntity.notFound().build(); // Si aucun camion n'est associé au voyage
        }

        return ResponseEntity.ok(camions);
    }

    @GetMapping("/{id}/conducteurs")
    public ResponseEntity<List<ConducteurDTO>> getConducteursForVoyage(@PathVariable Long id) {
        List<ConducteurDTO> conducteurs = conducteurService.getConducteursForVoyage(id);

        if (conducteurs.isEmpty()) {
            return ResponseEntity.notFound().build(); // Si aucun conducteur n'est associé au voyage
        }

        return ResponseEntity.ok(conducteurs);
    }


}
