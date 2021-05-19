package it.francesco.progetto.conrollers;

import it.francesco.progetto.entities.Acquisto;
import it.francesco.progetto.servicies.AcquistoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class AcquistoController {

    @Autowired
    private AcquistoService acquistoService;

    //restituisce tutti gli acquisti presenti sulla base di dati
    @GetMapping("acquisti")
    public ResponseEntity<List<Acquisto>> getAllAcquisto() {
        return acquistoService.getAllAcquisto();
    }

}
