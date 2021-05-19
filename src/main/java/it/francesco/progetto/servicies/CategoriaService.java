package it.francesco.progetto.servicies;

import it.francesco.progetto.entities.Categoria;
import it.francesco.progetto.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Transactional
    public ResponseEntity<Categoria> addCategoria(Categoria categoria) {
        return new ResponseEntity<>(categoriaRepository.save(categoria), HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<List<Categoria>> getAllCategoria() {
        return new ResponseEntity<>(categoriaRepository.findAll(), HttpStatus.OK);
    }
}
