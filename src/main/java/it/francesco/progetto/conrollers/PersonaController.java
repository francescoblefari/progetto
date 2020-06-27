package it.francesco.progetto.conrollers;

import it.francesco.progetto.entities.Acquisto;
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

    @GetMapping(path = "{id}")
    public Utente getPersonaById(@PathVariable("id") int id) {
        return utenteServicies.getPersonaById(id)
                .orElse(null);
    }

    @GetMapping("lista")
    public List<ProdottoInCarrello> listato(@RequestParam String username){
        Utente u = utenteServicies.getPersonaByUsername(username);
        if(utenteServicies.getPersonaById(1).isPresent())
            u = utenteServicies.getPersonaById(1).get();
        return u.getProdottoInCarrello();
    }

    @GetMapping("listaAcquisti")
    public List<Acquisto> listaAcquisti(){
        Utente u = new Utente();
        if(utenteServicies.getPersonaById(1).isPresent())
            u = utenteServicies.getPersonaById(1).get();
        return u.getLista();
    }

    @PostMapping("login")
    public Utente login(@RequestBody Utente u){
        return utenteServicies.getPersonaByUsername(u.getUsername());
    }

}
