package entities;

// Enumération représentant les états d'un compte
public enum EtatCompte {
    CREE, // Le compte est créé mais pas encore actif
    ACTIVE, // Le compte est actif et peut être utilisé
    SUSPENDU, // Le compte est suspendu, aucune transaction autorisée
    BLOQUE // Le compte est bloqué, aucune transaction autorisée
}
