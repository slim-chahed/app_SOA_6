package web;

import entities.Compte;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import repositories.CompteRepository;


import java.util.Date;
import java.util.List;
@Component
@Path("/banque")
public class CompteRestJaxRESAPI {

    @Autowired
    private CompteRepository compteRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/comptes")
    public List<Compte> compteList() {
        return compteRepository.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Compte getOne(@PathParam("id") Long id) {
        return compteRepository.findById(id).orElse(null);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void save(Compte compte) {
        compteRepository.save(compte);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(Compte compte, @PathParam("id") Long id) {
        compteRepository.findById(id).ifPresent(existingCompte -> {
            // Mettre à jour les attributs de existingCompte avec les valeurs de 'compte' et sauvegarder
            existingCompte.setSolde(compte.getSolde());
            existingCompte.setDatecreation(compte.getDatecreation());
            existingCompte.setType(compte.getType());
            existingCompte.setEtat(compte.getEtat());
            compteRepository.save(existingCompte);
        });
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        compteRepository.deleteById(id);
    }


}
