package it.francesco.progetto.conrollers;

import it.francesco.progetto.entities.DettaglioOrdine;
import it.francesco.progetto.entities.ProdottoInCarrello;
import it.francesco.progetto.entities.Prodotto;
import it.francesco.progetto.entities.Utente;
import it.francesco.progetto.servicies.UtenteServicies;
import it.francesco.progetto.servicies.ProdottoInCarrelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class ProdottoInCarrelloController {

    @Autowired
    private ProdottoInCarrelloService prodottoInCarrelloService;

    @PostMapping("aggiungi")
    public ProdottoInCarrello addProdottoInCarrello(@RequestBody ProdottoInCarrello p) {
        return prodottoInCarrelloService.addProdottoInCarrello(p);
    }

    @GetMapping("carrello")
    public List<ProdottoInCarrello> getAllProdottiInCarrello() {
        return prodottoInCarrelloService.getAllProdottiInCarrello();
    }

    @PostMapping("carrello")
    public List<ProdottoInCarrello> getProdottiInCarrelloByUsername( @RequestBody String username ) {
        List<ProdottoInCarrello> p = prodottoInCarrelloService.getProdottiInCarrelloByUsername(username);
        System.out.println(p);
        return p;
    }

    @PostMapping("eliminaDaCarrello")
    public void deleteProdottoInCarrello(@RequestBody ProdottoInCarrello p) {
        prodottoInCarrelloService.deleteProdottoInCarrello(p);
        System.out.println("sono qui");
    }

    @PostMapping("acquista")
    public List<DettaglioOrdine> acquistaCarrello(@RequestBody String username) {
        System.out.println("sono nel controller");
        return prodottoInCarrelloService.acquistaCarrello(username);
    }
}
