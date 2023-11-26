
package web;

import entities.EtatCompte;
import entities.typeCompte;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.CompteRepository;
import entities.Compte;

import java.util.Date;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "repositories")
// Active la configuration des dépôts JPA
@EntityScan(basePackages = "entities")
public class SalimChahedLsi3SoaTp6Application {

	public static void main(String[] args) {
		SpringApplication.run(SalimChahedLsi3SoaTp6Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(CompteRepository compteRepository) {
		return (args) -> {
			// Ajout de trois comptes pour la démonstration
			compteRepository.save(new Compte(null, 1000.0, new Date(), typeCompte.EPARGNE, EtatCompte.ACTIVE));
			compteRepository.save(new Compte(null, 500.0, new Date(), typeCompte.EPARGNE, EtatCompte.ACTIVE));
			compteRepository.save(new Compte(null, 1500.0, new Date(), typeCompte.COURANT, EtatCompte.ACTIVE));

			// Affichage des soldes des comptes
			System.out.println("Account Balances:");
			compteRepository.findAll().forEach(compte -> System.out.println("ID: " + compte.getId() + ", Balance: "
					+ compte.getSolde()));
		};
	}
}

