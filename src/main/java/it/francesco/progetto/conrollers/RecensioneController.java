package it.francesco.progetto.conrollers;

import it.francesco.progetto.entities.Prodotto;
import it.francesco.progetto.entities.Recensione;
import it.francesco.progetto.entities.Utente;
import it.francesco.progetto.servicies.RecensioneServices;
import it.francesco.progetto.supports.Invio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class RecensioneController {

    @Autowired
    private RecensioneServices recensioneServices;

    //primi due metodi non implementati nel frontEnd
    @PostMapping("aggiungiRecensione")
    public ResponseEntity<Recensione> addRecensione(@RequestBody Recensione recensione) {
        return recensioneServices.addCommento(recensione);
    }

    @GetMapping("visualizzaRecensioni")
    public ResponseEntity<List<Recensione>> getAllRecensione() {
        return recensioneServices.getAllRecensione();
    }

    //restituisce tutte le recensioni lasciate per un determinato prodotto
    @PostMapping("recensiti")
    public ResponseEntity<List<Recensione>> getRecensioneByProdotto(@RequestBody Prodotto p){
        return recensioneServices.getRecensioneProdotto(p);
    }

    //restituisce la lista di probotti che l'utente ha acquistato (almeno una volta) ma non ha recensito
    @PostMapping("recensibili")
    public ResponseEntity<List<Prodotto>> getRecensibiliByUtente(@RequestBody String username){
        return recensioneServices.getRecensibiliByUtente(username);
    }

    //tramite l'utilizzo di una classe di supporto, il metodo consente ad un utente di recensire un prodotto
    @PostMapping("recensisci")
    public void recensisci(@RequestBody Invio invio){
        recensioneServices.recensisci(invio);
    }
}
