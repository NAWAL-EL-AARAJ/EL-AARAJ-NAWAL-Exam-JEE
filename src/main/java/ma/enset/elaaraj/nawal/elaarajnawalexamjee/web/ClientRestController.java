package ma.enset.elaaraj.nawal.elaarajnawalexamjee.web;

import lombok.AllArgsConstructor;
import ma.enset.elaaraj.nawal.elaarajnawalexamjee.services.IAssuranceService;
import ma.enset.elaaraj.nawal.elaarajnawalexamjee.services.dtos.ClientDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
@AllArgsConstructor
@CrossOrigin("*")
public class ClientRestController {

    private IAssuranceService service;

    @GetMapping
    public List<ClientDTO> getAllClients() {
        return service.getAllClients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getClientById(id));
    }

    @GetMapping("/search")
    public List<ClientDTO> searchClients(@RequestParam String nom) {
        return service.searchClients(nom);
    }

    @PostMapping
    public ResponseEntity<ClientDTO> saveClient(@RequestBody ClientDTO dto) {
        return ResponseEntity.ok(service.saveClient(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable Long id,
                                                  @RequestBody ClientDTO dto) {
        return ResponseEntity.ok(service.updateClient(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        service.deleteClient(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/contrats")
    public ResponseEntity<?> getContratsByClient(@PathVariable Long id) {
        return ResponseEntity.ok(service.getContratsByClientId(id));
    }
}