package it.francesco.progetto.conrollers;

import it.francesco.progetto.entities.Prodotto;
import it.francesco.progetto.servicies.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("prodotto")
@CrossOrigin(origins = "http://localhost:4200")
public class ProdottoController {

    @Autowired
    private ProdottoService prodottoService;

    @PostMapping
    public Prodotto addProdotto(@RequestBody Prodotto prodotto) {
        return prodottoService.addProdotto(prodotto);
    }

    @GetMapping
    public List<Prodotto> getAllProdotto() {
        return prodottoService.getAllProdotto();
    }

}
