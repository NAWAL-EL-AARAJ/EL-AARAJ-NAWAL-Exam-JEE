package ma.enset.elaaraj.nawal.elaarajnawalexamjee.services;

import ma.enset.elaaraj.nawal.elaarajnawalexamjee.services.dtos.*;
import java.util.List;


public interface IAssuranceService {

    // ---- Client ----
    ClientDTO saveClient(ClientDTO clientDTO);
    ClientDTO getClientById(Long id);
    List<ClientDTO> getAllClients();
    ClientDTO updateClient(Long id, ClientDTO clientDTO);
    void deleteClient(Long id);
    List<ClientDTO> searchClients(String nom);

    // ---- Contrat Automobile ----
    ContratAutomobileDTO saveContratAutomobile(ContratAutomobileDTO dto);
    ContratAutomobileDTO getContratAutomobileById(Long id);
    List<ContratAutomobileDTO> getAllContratsAutomobile();
    ContratAutomobileDTO updateContratAutomobile(Long id, ContratAutomobileDTO dto);
    void deleteContrat(Long id);

    // ---- Contrat Habitation ----
    ContratHabitationDTO saveContratHabitation(ContratHabitationDTO dto);
    ContratHabitationDTO getContratHabitationById(Long id);
    List<ContratHabitationDTO> getAllContratsHabitation();
    ContratHabitationDTO updateContratHabitation(Long id, ContratHabitationDTO dto);

    // ---- Contrat Sante ----
    ContratSanteDTO saveContratSante(ContratSanteDTO dto);
    ContratSanteDTO getContratSanteById(Long id);
    List<ContratSanteDTO> getAllContratsSante();
    ContratSanteDTO updateContratSante(Long id, ContratSanteDTO dto);

    // ---- Contrats par client ----
    List<ContratAssuranceDTO> getContratsByClientId(Long clientId);

    // ---- Paiement ----
    PaiementDTO savePaiement(PaiementDTO dto);
    List<PaiementDTO> getPaiementsByContratId(Long contratId);
    List<PaiementDTO> getAllPaiements();
}