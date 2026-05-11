package ma.enset.elaaraj.nawal.elaarajnawalexamjee.web;

import lombok.AllArgsConstructor;
import ma.enset.elaaraj.nawal.elaarajnawalexamjee.services.IAssuranceService;
import ma.enset.elaaraj.nawal.elaarajnawalexamjee.services.dtos.ContratSanteDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/contrats/sante")
@AllArgsConstructor
@CrossOrigin("*")
public class ContratSanteRestController {

    private IAssuranceService service;

    @GetMapping
    public List<ContratSanteDTO> getAll() {
        return service.getAllContratsSante();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContratSanteDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getContratSanteById(id));
    }

    @PostMapping
    public ResponseEntity<ContratSanteDTO> save(@RequestBody ContratSanteDTO dto) {
        return ResponseEntity.ok(service.saveContratSante(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContratSanteDTO> update(@PathVariable Long id,
                                                  @RequestBody ContratSanteDTO dto) {
        return ResponseEntity.ok(service.updateContratSante(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteContrat(id);
        return ResponseEntity.noContent().build();
    }
}