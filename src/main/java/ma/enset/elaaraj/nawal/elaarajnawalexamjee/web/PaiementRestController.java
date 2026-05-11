package ma.enset.elaaraj.nawal.elaarajnawalexamjee.web;

import lombok.AllArgsConstructor;
import ma.enset.elaaraj.nawal.elaarajnawalexamjee.services.IAssuranceService;
import ma.enset.elaaraj.nawal.elaarajnawalexamjee.services.dtos.PaiementDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/paiements")
@AllArgsConstructor
@CrossOrigin("*")
public class PaiementRestController {

    private IAssuranceService service;

    @GetMapping
    public List<PaiementDTO> getAll() {
        return service.getAllPaiements();
    }

    @GetMapping("/contrat/{contratId}")
    public List<PaiementDTO> getByContrat(@PathVariable Long contratId) {
        return service.getPaiementsByContratId(contratId);
    }

    @PostMapping
    public ResponseEntity<PaiementDTO> save(@RequestBody PaiementDTO dto) {
        return ResponseEntity.ok(service.savePaiement(dto));
    }
}