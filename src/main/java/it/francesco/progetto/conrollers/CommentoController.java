package it.francesco.progetto.conrollers;

import it.francesco.progetto.entities.Commento;
import it.francesco.progetto.servicies.CommentoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("commento")
public class CommentoController {

    @Autowired
    private CommentoServices commentoServices;

    @PostMapping
    public Commento addCommento(@RequestBody Commento commento){ return commentoServices.addCommento(commento);}

    @GetMapping
    public List<Commento> getAllCommento(){ return commentoServices.getAllCommento();}
}
