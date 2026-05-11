package ma.enset.elaaraj.nawal.elaarajnawalexamjee.web;

import lombok.AllArgsConstructor;
import ma.enset.elaaraj.nawal.elaarajnawalexamjee.services.IAssuranceService;
import ma.enset.elaaraj.nawal.elaarajnawalexamjee.services.dtos.ContratHabitationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/contrats/habitation")
@AllArgsConstructor
@CrossOrigin("*")
public class ContratHabitationRestController {

    private IAssuranceService service;

    @GetMapping
    public List<ContratHabitationDTO> getAll() {
        return service.getAllContratsHabitation();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContratHabitationDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getContratHabitationById(id));
    }

    @PostMapping
    public ResponseEntity<ContratHabitationDTO> save(@RequestBody ContratHabitationDTO dto) {
        return ResponseEntity.ok(service.saveContratHabitation(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContratHabitationDTO> update(@PathVariable Long id,
                                                       @RequestBody ContratHabitationDTO dto) {
        return ResponseEntity.ok(service.updateContratHabitation(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteContrat(id);
        return ResponseEntity.noContent().build();
    }
}