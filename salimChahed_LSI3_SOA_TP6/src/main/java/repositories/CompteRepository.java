package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import entities.Compte;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {
    // Interface reposant sur Spring Data JPA pour les opérations CRUD sur les comptes

}

