package ma.enset.elaaraj.nawal.elaarajnawalexamjee.web;

import lombok.AllArgsConstructor;
import ma.enset.elaaraj.nawal.elaarajnawalexamjee.services.IAssuranceService;
import ma.enset.elaaraj.nawal.elaarajnawalexamjee.services.dtos.ContratAutomobileDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/contrats/automobile")
@AllArgsConstructor
@CrossOrigin("*")
public class ContratAutomobileRestController {

    private IAssuranceService service;

    @GetMapping
    public List<ContratAutomobileDTO> getAll() {
        return service.getAllContratsAutomobile();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContratAutomobileDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getContratAutomobileById(id));
    }

    @PostMapping
    public ResponseEntity<ContratAutomobileDTO> save(@RequestBody ContratAutomobileDTO dto) {
        return ResponseEntity.ok(service.saveContratAutomobile(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContratAutomobileDTO> update(@PathVariable Long id,
                                                       @RequestBody ContratAutomobileDTO dto) {
        return ResponseEntity.ok(service.updateContratAutomobile(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteContrat(id);
        return ResponseEntity.noContent().build();
    }
}