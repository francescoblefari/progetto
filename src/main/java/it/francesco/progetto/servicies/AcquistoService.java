package it.francesco.progetto.servicies;

import it.francesco.progetto.entities.Acquisto;
import it.francesco.progetto.repositories.AcquistoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcquistoService {

    @Autowired
    private AcquistoRepository acquistoRepository;

    public List<Acquisto> getAllAcquisto() {
        return acquistoRepository.findAll();
    }


}
