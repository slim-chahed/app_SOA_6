package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Utilisation de l'auto-incrémentation pour la génération de l'ID
    Long id; // Identifiant unique du compte
    double solde; // Solde du compte
    Date datecreation; // Date de création du compte
    typeCompte type; // Type de compte (courant ou épargne)
    EtatCompte etat; // État actuel du compte
}
