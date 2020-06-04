package it.francesco.progetto.conrollers;

import it.francesco.progetto.entities.Utente;
import it.francesco.progetto.servicies.PersonaServicies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {

    @Autowired
    private PersonaServicies personaServicies;

    @PostMapping("users")
    public Utente addPerson(@RequestBody Utente utente){
        return personaServicies.addPersona(utente);
    }

    @GetMapping("users")
    public List<Utente> getAllPersona(){
        return personaServicies.getAllPersona();
    }

    @GetMapping(path = "{id}")
    public Utente getPersonaById(@PathVariable("id") String id){
        return personaServicies.getPersonaById(id)
                .orElse(null);
    }
}
