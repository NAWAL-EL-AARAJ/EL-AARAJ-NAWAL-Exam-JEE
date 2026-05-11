package ma.enset.elaaraj.nawal.elaarajnawalexamjee;

import ma.enset.elaaraj.nawal.elaarajnawalexamjee.entities.*;
import ma.enset.elaaraj.nawal.elaarajnawalexamjee.enums.*;
import ma.enset.elaaraj.nawal.elaarajnawalexamjee.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.Date;

@SpringBootApplication
public class ElAarajNawalExamJeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElAarajNawalExamJeeApplication.class, args);
    }

    @Bean
    CommandLineRunner initData(
            ClientRepository clientRepo,
            ContratAutomobileRepository autoRepo,
            ContratHabitationRepository habitRepo,
            ContratSanteRepository santeRepo,
            PaiementRepository paiementRepo
    ) {
        return args -> {
            Client c1 = clientRepo.save(Client.builder()
                    .nom("Ahmed Bennani").email("ahmed@gmail.com").build());
            Client c2 = clientRepo.save(Client.builder()
                    .nom("Sara Idrissi").email("sara@gmail.com").build());
            Client c3 = clientRepo.save(Client.builder()
                    .nom("Youssef Alami").email("youssef@gmail.com").build());

            ContratAutomobile ca1 = new ContratAutomobile();
            ca1.setClient(c1); ca1.setDateSouscription(new Date());
            ca1.setStatut(StatutContrat.EN_COURS); ca1.setMontantCotisation(1500.0);
            ca1.setDureeContrat(12); ca1.setTauxCouverture(80.0);
            ca1.setNumImmatriculation("123456-A-7");
            ca1.setMarque("Toyota"); ca1.setModele("Corolla");
            autoRepo.save(ca1);

            ContratAutomobile ca2 = new ContratAutomobile();
            ca2.setClient(c2); ca2.setDateSouscription(new Date());
            ca2.setStatut(StatutContrat.VALIDE); ca2.setMontantCotisation(2000.0);
            ca2.setDureeContrat(24); ca2.setTauxCouverture(90.0);
            ca2.setNumImmatriculation("654321-B-5");
            ca2.setMarque("Renault"); ca2.setModele("Clio");
            autoRepo.save(ca2);

            ContratHabitation ch1 = new ContratHabitation();
            ch1.setClient(c1); ch1.setDateSouscription(new Date());
            ch1.setStatut(StatutContrat.EN_COURS); ch1.setMontantCotisation(800.0);
            ch1.setDureeContrat(12); ch1.setTauxCouverture(75.0);
            ch1.setTypeLogement(TypeLogement.APPARTEMENT);
            ch1.setAdresse("Rue Hassan II, Casablanca"); ch1.setSuperficie(85.0);
            habitRepo.save(ch1);

            ContratSante cs1 = new ContratSante();
            cs1.setClient(c3); cs1.setDateSouscription(new Date());
            cs1.setStatut(StatutContrat.EN_COURS); cs1.setMontantCotisation(3000.0);
            cs1.setDureeContrat(12); cs1.setTauxCouverture(95.0);
            cs1.setNiveauCouverture(NiveauCouverture.PREMIUM);
            cs1.setNbPersonnesCouvertes(4);
            santeRepo.save(cs1);

            paiementRepo.save(Paiement.builder().date(new Date())
                    .montant(1500.0).typePaiement(TypePaiement.MENSUALITE)
                    .contrat(ca1).build());
            paiementRepo.save(Paiement.builder().date(new Date())
                    .montant(2000.0).typePaiement(TypePaiement.PAIEMENT_ANNUEL)
                    .contrat(ca2).build());
            paiementRepo.save(Paiement.builder().date(new Date())
                    .montant(800.0).typePaiement(TypePaiement.MENSUALITE)
                    .contrat(ch1).build());

            System.out.println("Base de données initialisée avec succès !");
        };
    }
}