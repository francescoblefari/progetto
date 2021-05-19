package it.francesco.progetto.conrollers;

import it.francesco.progetto.entities.DettaglioOrdine;
import it.francesco.progetto.entities.Utente;
import it.francesco.progetto.repositories.UtenteRepository;
import it.francesco.progetto.servicies.DettaglioOrdineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class DettaglioOrdineController {

    @Autowired
    private DettaglioOrdineService dettaglioOrdineService;

    /*
    * effettua una query per ricercare tutti gli ordini effettuati da un determinato utente
    * nella pratica ho poi implementato quella presente in UtenteServices in quanto più efficiente
    * */
    @PostMapping("getDettaglioOrdine")
    public ResponseEntity<List<DettaglioOrdine>> getAllByIdUtente(@RequestBody String username) {
        return dettaglioOrdineService.getAllByUsernameUtente(username);
    }


}
