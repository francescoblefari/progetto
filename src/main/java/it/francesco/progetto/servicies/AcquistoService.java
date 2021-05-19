package it.francesco.progetto.servicies;

import it.francesco.progetto.entities.Acquisto;
import it.francesco.progetto.repositories.AcquistoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AcquistoService {

    @Autowired
    private AcquistoRepository acquistoRepository;

    @Transactional
    public ResponseEntity<List<Acquisto>> getAllAcquisto() {
        return new ResponseEntity<>(acquistoRepository.findAll(), HttpStatus.OK);
    }


}
