package it.francesco.progetto.conrollers;

import it.francesco.progetto.entities.DettaglioOrdine;
import it.francesco.progetto.entities.ProdottoInCarrello;
import it.francesco.progetto.entities.Prodotto;
import it.francesco.progetto.entities.Utente;
import it.francesco.progetto.servicies.UtenteServicies;
import it.francesco.progetto.servicies.ProdottoInCarrelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class ProdottoInCarrelloController {

    @Autowired
    private ProdottoInCarrelloService prodottoInCarrelloService;

    //aggiunge prodottoInCarrello da un ProdottoInCarrello passto dal frontEnd
    @PostMapping("aggiungi")
    public void addProdottoInCarrello(@RequestBody ProdottoInCarrello p) {
        prodottoInCarrelloService.addProdottoInCarrello(p);
    }

    //visualizza tutte le entry per prodottoInCarrello
    @GetMapping("getAllProdottoInCarrello")
    public ResponseEntity<List<ProdottoInCarrello>> getAllProdottiInCarrello() {
        return prodottoInCarrelloService.getAllProdottiInCarrello();
    }

    //restituisce la lista dei prodottiInCarrello di un determinato utente
    @PostMapping("carrello")
    public ResponseEntity<List<ProdottoInCarrello>> getProdottiInCarrelloByUsername(@RequestBody String username ) {
        return prodottoInCarrelloService.getProdottiInCarrelloByUsername(username);
    }

    //dato un prodotto in carrello consente di eliminarlo
    @PostMapping("eliminaDaCarrello")
    public void deleteProdottoInCarrello(@RequestBody ProdottoInCarrello p) {
        prodottoInCarrelloService.deleteProdottoInCarrello(p);
    }

    //effettua l'ordine di tutti i prodotti presenti nel carrello di un determinato utente
    @PostMapping("acquista")
    public void acquistaCarrello(@RequestBody String username) {
        prodottoInCarrelloService.acquistaCarrello(username);
    }
}
