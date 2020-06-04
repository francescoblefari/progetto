package it.francesco.progetto.servicies;

import it.francesco.progetto.entities.Utente;
import it.francesco.progetto.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonaServicies {

    @Autowired
    private PersonaRepository personaRepository;

    public Utente addPersona(Utente utente){ return personaRepository.save(utente); }

    public List<Utente> getAllPersona(){ return personaRepository.findAll(); }

    public Optional<Utente> getPersonaById(String id){ return personaRepository.findById(id); }

}