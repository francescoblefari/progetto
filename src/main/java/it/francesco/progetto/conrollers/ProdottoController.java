package it.francesco.progetto.conrollers;

import it.francesco.progetto.entities.Prodotto;
import it.francesco.progetto.servicies.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("prodotto")
@CrossOrigin(origins = "http://localhost:4200")
public class ProdottoController {

    @Autowired
    private ProdottoService prodottoService;

    //aggiunge un prodotto nel db
    @PostMapping
    public ResponseEntity<Prodotto> addProdotto(@RequestBody Prodotto prodotto) {
        return prodottoService.addProdotto(prodotto);
    }

    //restituisce la lista dei prodotti
    @GetMapping("getProdotti")
    public ResponseEntity<List<Prodotto>> getAllProdotto() {
        return prodottoService.getAllProdotto();
    }

    @PostMapping("getProdotto")
    public ResponseEntity<Prodotto> getProdotto(@RequestBody String id) {
        return prodottoService.getProdotto(id);
    }


}
