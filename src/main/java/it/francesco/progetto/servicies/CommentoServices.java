package it.francesco.progetto.servicies;

import it.francesco.progetto.entities.Commento;
import it.francesco.progetto.repositories.CommentoRepository;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentoServices {

    @Autowired
    private CommentoRepository commentoRepository;

    public Commento addCommento(Commento commento){ return commentoRepository.save(commento);}

    public List<Commento> getAllCommento(){ return commentoRepository.findAll();}

}
