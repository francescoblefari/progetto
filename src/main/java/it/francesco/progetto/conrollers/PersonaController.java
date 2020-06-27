package it.francesco.progetto.conrollers;

import it.francesco.progetto.entities.ProdottoInCarrello;
import it.francesco.progetto.entities.Utente;
import it.francesco.progetto.servicies.UtenteServicies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {

    @Autowired
    private UtenteServicies utenteServicies;

    @PostMapping("users")
    public Utente addPerson(@RequestBody Utente utente) {
        return utenteServicies.addPersona(utente);
    }

    @PostMapping("usersAll")
    public void riempiPersona(@RequestBody List<Utente> l) {
        utenteServicies.addAllPersona(l);
    }

    @GetMapping("users")
    public List<Utente> getAllPersona() {
        return utenteServicies.getAllPersona();
    }

    @PostMapping("listaProdottoInCarrello")
    public List<ProdottoInCarrello> listato(@RequestBody String username){
        return utenteServicies.listaProdottoInCarrelloByUsername(username);
    }

    @PostMapping("login")
    public Utente login(@RequestBody Utente u){
        return utenteServicies.getPersonaByUsername(u.getUsername());
    }

}
