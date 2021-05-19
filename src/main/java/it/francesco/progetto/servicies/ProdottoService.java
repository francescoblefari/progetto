package it.francesco.progetto.servicies;

import it.francesco.progetto.entities.Prodotto;
import it.francesco.progetto.repositories.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdottoService {

    @Autowired
    private ProdottoRepository prodottoRepository;

    @Transactional
    public ResponseEntity<Prodotto> addProdotto(Prodotto prodotto) {
        return new ResponseEntity<>(prodottoRepository.save(prodotto), HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<List<Prodotto>> getAllProdotto() {
        return new ResponseEntity<>(prodottoRepository.findAll(), HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<Prodotto> getProdotto( String id ) {
        int idInt = Integer.parseInt(id);
        //System.out.println(prodottoRepository.findById(idInt).get());
        return new ResponseEntity<>(prodottoRepository.findById(idInt).get(), HttpStatus.OK);
    }
}
