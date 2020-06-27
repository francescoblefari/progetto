package it.francesco.progetto.conrollers;

import it.francesco.progetto.entities.Prodotto;
import it.francesco.progetto.entities.Recensione;
import it.francesco.progetto.entities.Utente;
import it.francesco.progetto.servicies.RecensioneServices;
import it.francesco.progetto.supports.Invio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class RecensioneController {

    @Autowired
    private RecensioneServices recensioneServices;

    @PostMapping
    public Recensione addRecensione(@RequestBody Recensione recensione) {
        return recensioneServices.addCommento(recensione);
    }

    @GetMapping
    public List<Recensione> getAllRecensione() {
        return recensioneServices.getAllRecensione();
    }

    @PostMapping("recensiti")
    public List<Recensione> getRecensioneByProdotto(@RequestBody Prodotto p){
        return recensioneServices.getRecensioneProdotto(p);
    }

    @PostMapping("recensibili")
    public List<Prodotto> getRecensibiliByUtente(@RequestBody String username){
        return recensioneServices.getRecensibiliByUtente(username);
    }

    @PostMapping("recensisci")
    public void recensisci(@RequestBody Invio invio){
        Prodotto p = invio.getProdotto();
        String recensione = invio.getValore();
        String username = invio.getUsername();
        recensioneServices.recensisci(recensione, p, username);

    }
}
