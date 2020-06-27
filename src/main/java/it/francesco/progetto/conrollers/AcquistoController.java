package it.francesco.progetto.conrollers;

import it.francesco.progetto.entities.Acquisto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class AcquistoController {

    @Autowired
    private AcquistoController acquistoController;

    @GetMapping("acquisti")
    public List<Acquisto> getAllAcquisto() {
        return acquistoController.getAllAcquisto();
    }

}
