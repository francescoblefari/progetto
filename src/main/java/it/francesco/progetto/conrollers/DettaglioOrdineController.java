package it.francesco.progetto.conrollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DettaglioOrdineController {

    @GetMapping
    public String stampa(){return "ciao";}
}
