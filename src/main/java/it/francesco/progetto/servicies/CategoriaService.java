package it.francesco.progetto.servicies;

import it.francesco.progetto.entities.Categoria;
import it.francesco.progetto.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria addCategoria(Categoria categoria){ return categoriaRepository.save(categoria);}

    public List<Categoria> getAllCategoria(){ return categoriaRepository.findAll(); }
}
