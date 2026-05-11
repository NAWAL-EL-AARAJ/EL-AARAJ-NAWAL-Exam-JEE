package ma.enset.elaaraj.nawal.elaarajnawalexamjee.services.impl;

import lombok.AllArgsConstructor;
import ma.enset.elaaraj.nawal.elaarajnawalexamjee.entities.Client;
import ma.enset.elaaraj.nawal.elaarajnawalexamjee.entities.ContratAssurance;
import ma.enset.elaaraj.nawal.elaarajnawalexamjee.entities.ContratAutomobile;
import ma.enset.elaaraj.nawal.elaarajnawalexamjee.entities.ContratHabitation;
import ma.enset.elaaraj.nawal.elaarajnawalexamjee.entities.ContratSante;
import ma.enset.elaaraj.nawal.elaarajnawalexamjee.entities.Paiement;
import ma.enset.elaaraj.nawal.elaarajnawalexamjee.repositories.ClientRepository;
import ma.enset.elaaraj.nawal.elaarajnawalexamjee.repositories.ContratAssuranceRepository;
import ma.enset.elaaraj.nawal.elaarajnawalexamjee.repositories.ContratAutomobileRepository;
import ma.enset.elaaraj.nawal.elaarajnawalexamjee.repositories.ContratHabitationRepository;
import ma.enset.elaaraj.nawal.elaarajnawalexamjee.repositories.ContratSanteRepository;
import ma.enset.elaaraj.nawal.elaarajnawalexamjee.repositories.PaiementRepository;
import ma.enset.elaaraj.nawal.elaarajnawalexamjee.services.IAssuranceService;
import ma.enset.elaaraj.nawal.elaarajnawalexamjee.services.dtos.ClientDTO;
import ma.enset.elaaraj.nawal.elaarajnawalexamjee.services.dtos.ContratAssuranceDTO;
import ma.enset.elaaraj.nawal.elaarajnawalexamjee.services.dtos.ContratAutomobileDTO;
import ma.enset.elaaraj.nawal.elaarajnawalexamjee.services.dtos.ContratHabitationDTO;
import ma.enset.elaaraj.nawal.elaarajnawalexamjee.services.dtos.ContratSanteDTO;
import ma.enset.elaaraj.nawal.elaarajnawalexamjee.services.dtos.PaiementDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class AssuranceServiceImpl implements IAssuranceService {

    private ClientRepository clientRepository;
    private ContratAssuranceRepository contratRepository;
    private ContratAutomobileRepository autoRepository;
    private ContratHabitationRepository habitRepository;
    private ContratSanteRepository santeRepository;
    private PaiementRepository paiementRepository;

    // ========== MAPPERS MANUELS ==========

    private ClientDTO toClientDTO(Client c) {
        return ClientDTO.builder()
                .id(c.getId()).nom(c.getNom()).email(c.getEmail())
                .build();
    }

    private Client toClient(ClientDTO dto) {
        return Client.builder()
                .nom(dto.getNom()).email(dto.getEmail())
                .build();
    }

    private ContratAutomobileDTO toAutoDTO(ContratAutomobile c) {
        return ContratAutomobileDTO.builder()
                .id(c.getId())
                .dateSouscription(c.getDateSouscription())
                .statut(c.getStatut())
                .dateValidation(c.getDateValidation())
                .montantCotisation(c.getMontantCotisation())
                .dureeContrat(c.getDureeContrat())
                .tauxCouverture(c.getTauxCouverture())
                .clientId(c.getClient() != null ? c.getClient().getId() : null)
                .clientNom(c.getClient() != null ? c.getClient().getNom() : null)
                .numImmatriculation(c.getNumImmatriculation())
                .marque(c.getMarque())
                .modele(c.getModele())
                .build();
    }

    private ContratHabitationDTO toHabitDTO(ContratHabitation c) {
        return ContratHabitationDTO.builder()
                .id(c.getId())
                .dateSouscription(c.getDateSouscription())
                .statut(c.getStatut())
                .dateValidation(c.getDateValidation())
                .montantCotisation(c.getMontantCotisation())
                .dureeContrat(c.getDureeContrat())
                .tauxCouverture(c.getTauxCouverture())
                .clientId(c.getClient() != null ? c.getClient().getId() : null)
                .clientNom(c.getClient() != null ? c.getClient().getNom() : null)
                .typeLogement(c.getTypeLogement())
                .adresse(c.getAdresse())
                .superficie(c.getSuperficie())
                .build();
    }

    private ContratSanteDTO toSanteDTO(ContratSante c) {
        return ContratSanteDTO.builder()
                .id(c.getId())
                .dateSouscription(c.getDateSouscription())
                .statut(c.getStatut())
                .dateValidation(c.getDateValidation())
                .montantCotisation(c.getMontantCotisation())
                .dureeContrat(c.getDureeContrat())
                .tauxCouverture(c.getTauxCouverture())
                .clientId(c.getClient() != null ? c.getClient().getId() : null)
                .clientNom(c.getClient() != null ? c.getClient().getNom() : null)
                .niveauCouverture(c.getNiveauCouverture())
                .nbPersonnesCouvertes(c.getNbPersonnesCouvertes())
                .build();
    }

    private ContratAssuranceDTO toContratDTO(ContratAssurance c) {
        return ContratAssuranceDTO.builder()
                .id(c.getId())
                .dateSouscription(c.getDateSouscription())
                .statut(c.getStatut())
                .dateValidation(c.getDateValidation())
                .montantCotisation(c.getMontantCotisation())
                .dureeContrat(c.getDureeContrat())
                .tauxCouverture(c.getTauxCouverture())
                .clientId(c.getClient() != null ? c.getClient().getId() : null)
                .clientNom(c.getClient() != null ? c.getClient().getNom() : null)
                .build();
    }

    private PaiementDTO toPaiementDTO(Paiement p) {
        return PaiementDTO.builder()
                .id(p.getId()).date(p.getDate())
                .montant(p.getMontant())
                .typePaiement(p.getTypePaiement())
                .contratId(p.getContrat() != null ? p.getContrat().getId() : null)
                .build();
    }

    // ========== CLIENT ==========

    @Override
    public ClientDTO saveClient(ClientDTO dto) {
        Client client = toClient(dto);
        return toClientDTO(clientRepository.save(client));
    }

    @Override
    public ClientDTO getClientById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client non trouvé : " + id));
        return toClientDTO(client);
    }

    @Override
    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll()
                .stream().map(this::toClientDTO).collect(Collectors.toList());
    }

    @Override
    public ClientDTO updateClient(Long id, ClientDTO dto) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client non trouvé : " + id));
        client.setNom(dto.getNom());
        client.setEmail(dto.getEmail());
        return toClientDTO(clientRepository.save(client));
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public List<ClientDTO> searchClients(String nom) {
        return clientRepository.findByNomContainingIgnoreCase(nom)
                .stream().map(this::toClientDTO).collect(Collectors.toList());
    }

    // ========== CONTRAT AUTOMOBILE ==========

    @Override
    public ContratAutomobileDTO saveContratAutomobile(ContratAutomobileDTO dto) {
        Client client = clientRepository.findById(dto.getClientId())
                .orElseThrow(() -> new RuntimeException("Client non trouvé"));
        ContratAutomobile c = new ContratAutomobile();
        c.setClient(client);
        c.setDateSouscription(dto.getDateSouscription());
        c.setStatut(dto.getStatut());
        c.setMontantCotisation(dto.getMontantCotisation());
        c.setDureeContrat(dto.getDureeContrat());
        c.setTauxCouverture(dto.getTauxCouverture());
        c.setNumImmatriculation(dto.getNumImmatriculation());
        c.setMarque(dto.getMarque());
        c.setModele(dto.getModele());
        return toAutoDTO(autoRepository.save(c));
    }

    @Override
    public ContratAutomobileDTO getContratAutomobileById(Long id) {
        ContratAutomobile c = autoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrat auto non trouvé : " + id));
        return toAutoDTO(c);
    }

    @Override
    public List<ContratAutomobileDTO> getAllContratsAutomobile() {
        return autoRepository.findAll()
                .stream().map(this::toAutoDTO).collect(Collectors.toList());
    }

    @Override
    public ContratAutomobileDTO updateContratAutomobile(Long id, ContratAutomobileDTO dto) {
        ContratAutomobile c = autoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrat auto non trouvé : " + id));
        c.setStatut(dto.getStatut());
        c.setMontantCotisation(dto.getMontantCotisation());
        c.setDureeContrat(dto.getDureeContrat());
        c.setTauxCouverture(dto.getTauxCouverture());
        c.setNumImmatriculation(dto.getNumImmatriculation());
        c.setMarque(dto.getMarque());
        c.setModele(dto.getModele());
        return toAutoDTO(autoRepository.save(c));
    }

    @Override
    public void deleteContrat(Long id) {
        contratRepository.deleteById(id);
    }

    // ========== CONTRAT HABITATION ==========

    @Override
    public ContratHabitationDTO saveContratHabitation(ContratHabitationDTO dto) {
        Client client = clientRepository.findById(dto.getClientId())
                .orElseThrow(() -> new RuntimeException("Client non trouvé"));
        ContratHabitation c = new ContratHabitation();
        c.setClient(client);
        c.setDateSouscription(dto.getDateSouscription());
        c.setStatut(dto.getStatut());
        c.setMontantCotisation(dto.getMontantCotisation());
        c.setDureeContrat(dto.getDureeContrat());
        c.setTauxCouverture(dto.getTauxCouverture());
        c.setTypeLogement(dto.getTypeLogement());
        c.setAdresse(dto.getAdresse());
        c.setSuperficie(dto.getSuperficie());
        return toHabitDTO(habitRepository.save(c));
    }

    @Override
    public ContratHabitationDTO getContratHabitationById(Long id) {
        ContratHabitation c = habitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrat habitation non trouvé : " + id));
        return toHabitDTO(c);
    }

    @Override
    public List<ContratHabitationDTO> getAllContratsHabitation() {
        return habitRepository.findAll()
                .stream().map(this::toHabitDTO).collect(Collectors.toList());
    }

    @Override
    public ContratHabitationDTO updateContratHabitation(Long id, ContratHabitationDTO dto) {
        ContratHabitation c = habitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrat habitation non trouvé : " + id));
        c.setStatut(dto.getStatut());
        c.setMontantCotisation(dto.getMontantCotisation());
        c.setDureeContrat(dto.getDureeContrat());
        c.setTauxCouverture(dto.getTauxCouverture());
        c.setTypeLogement(dto.getTypeLogement());
        c.setAdresse(dto.getAdresse());
        c.setSuperficie(dto.getSuperficie());
        return toHabitDTO(habitRepository.save(c));
    }

    // ========== CONTRAT SANTE ==========

    @Override
    public ContratSanteDTO saveContratSante(ContratSanteDTO dto) {
        Client client = clientRepository.findById(dto.getClientId())
                .orElseThrow(() -> new RuntimeException("Client non trouvé"));
        ContratSante c = new ContratSante();
        c.setClient(client);
        c.setDateSouscription(dto.getDateSouscription());
        c.setStatut(dto.getStatut());
        c.setMontantCotisation(dto.getMontantCotisation());
        c.setDureeContrat(dto.getDureeContrat());
        c.setTauxCouverture(dto.getTauxCouverture());
        c.setNiveauCouverture(dto.getNiveauCouverture());
        c.setNbPersonnesCouvertes(dto.getNbPersonnesCouvertes());
        return toSanteDTO(santeRepository.save(c));
    }

    @Override
    public ContratSanteDTO getContratSanteById(Long id) {
        ContratSante c = santeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrat santé non trouvé : " + id));
        return toSanteDTO(c);
    }

    @Override
    public List<ContratSanteDTO> getAllContratsSante() {
        return santeRepository.findAll()
                .stream().map(this::toSanteDTO).collect(Collectors.toList());
    }

    @Override
    public ContratSanteDTO updateContratSante(Long id, ContratSanteDTO dto) {
        ContratSante c = santeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrat santé non trouvé : " + id));
        c.setStatut(dto.getStatut());
        c.setMontantCotisation(dto.getMontantCotisation());
        c.setDureeContrat(dto.getDureeContrat());
        c.setTauxCouverture(dto.getTauxCouverture());
        c.setNiveauCouverture(dto.getNiveauCouverture());
        c.setNbPersonnesCouvertes(dto.getNbPersonnesCouvertes());
        return toSanteDTO(santeRepository.save(c));
    }

    // ========== CONTRATS PAR CLIENT ==========

    @Override
    public List<ContratAssuranceDTO> getContratsByClientId(Long clientId) {
        return contratRepository.findByClientId(clientId)
                .stream().map(this::toContratDTO).collect(Collectors.toList());
    }

    // ========== PAIEMENT ==========

    @Override
    public PaiementDTO savePaiement(PaiementDTO dto) {
        ContratAssurance contrat = contratRepository.findById(dto.getContratId())
                .orElseThrow(() -> new RuntimeException("Contrat non trouvé"));
        Paiement p = Paiement.builder()
                .date(dto.getDate())
                .montant(dto.getMontant())
                .typePaiement(dto.getTypePaiement())
                .contrat(contrat)
                .build();
        return toPaiementDTO(paiementRepository.save(p));
    }

    @Override
    public List<PaiementDTO> getPaiementsByContratId(Long contratId) {
        return paiementRepository.findByContratId(contratId)
                .stream().map(this::toPaiementDTO).collect(Collectors.toList());
    }

    @Override
    public List<PaiementDTO> getAllPaiements() {
        return paiementRepository.findAll()
                .stream().map(this::toPaiementDTO).collect(Collectors.toList());
    }
}