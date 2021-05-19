package it.francesco.progetto.conrollers;

import it.francesco.progetto.entities.DettaglioOrdine;
import it.francesco.progetto.entities.ProdottoInCarrello;
import it.francesco.progetto.entities.Utente;
import it.francesco.progetto.servicies.UtenteServicies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UtenteController {

    @Autowired
    private UtenteServicies utenteServicies;

    //consente di aggiungere un utente
    @PostMapping("users")
    public ResponseEntity<Utente> addPerson(@RequestBody Utente utente) {
        return utenteServicies.addPersona(utente);
    }

    //consente di aggiungere più utenti
    @PostMapping("usersAll")
    public void riempiPersona(@RequestBody List<Utente> l) {
        utenteServicies.addAllPersona(l);
    }

    //restituisce la lista di tutti gli utenti nel db
    @GetMapping("users")
    public ResponseEntity<List<Utente>> getAllPersona() {
        return utenteServicies.getAllPersona();
    }

    /*
    * dato che un utente si mantiene la lista dei prodotti in carrello, la query può essere effettuata
    * in maniera piu efficiente restituendo semplicemente la lista
    */
    @PostMapping("listaProdottoInCarrello")
    public ResponseEntity<List<ProdottoInCarrello>> listato(@RequestBody String username){
        return utenteServicies.listaProdottoInCarrelloByUsername(username);
    }

    /*
    * se l'utente è presente effettua il login
    * */
    @PostMapping("login")
    public Utente login(@RequestBody Utente u){
        return utenteServicies.getPersonaByUsername(u.getUsername());
    }

    /*
    * dato un utente ritorna la lista degli ordini che ha effettuato
    * */
    @PostMapping("getListDettaglioOrdine")
    public ResponseEntity<List<DettaglioOrdine>> getListDettaglioOrdine(@RequestBody String username){
        return utenteServicies.listDettaglioOrdine(username);
    }

}
