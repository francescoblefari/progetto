package it.francesco.progetto.conrollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DettaglioOrdineController {

    @GetMapping
    public String stampa(){return "ciao";}

    @PostMapping
    public void aggiungi(){ System.out.println("ciao"); }
}
