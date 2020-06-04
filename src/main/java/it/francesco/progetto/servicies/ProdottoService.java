package it.francesco.progetto.servicies;

import it.francesco.progetto.entities.Prodotto;
import it.francesco.progetto.repositories.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdottoService {

    @Autowired
    private ProdottoRepository prodottoRepository;

    public Prodotto addProdotto( Prodotto prodotto ){ return prodottoRepository.save(prodotto);}

    public List<Prodotto> getAllProdotto(){ return prodottoRepository.findAll();}
}
