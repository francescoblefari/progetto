package it.francesco.progetto.servicies;

import it.francesco.progetto.entities.ProdottoInCarrello;
import it.francesco.progetto.entities.Utente;
import it.francesco.progetto.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtenteServicies {

    @Autowired
    private UtenteRepository utenteRepository;

    public Utente addPersona(Utente utente) {
        return utenteRepository.save(utente);
    }

    public void addAllPersona(List<Utente> l) {
        utenteRepository.saveAll(l);
    }

    public List<Utente> getAllPersona() {
        return utenteRepository.findAll();
    }

    public Optional<Utente> getPersonaById(int id) {
        return utenteRepository.findById(id);
    }

    public Utente getPersonaByUsername(String username){
        Utente u = utenteRepository.findUtenteByUsername(username);
        System.out.println(u);
        System.out.println(username);
        if(u==null) return null;
        if(username.equals(u.getUsername()))
            return u;
        return null;
    }

}