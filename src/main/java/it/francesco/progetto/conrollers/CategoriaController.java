package it.francesco.progetto.conrollers;

import it.francesco.progetto.entities.Categoria;
import it.francesco.progetto.servicies.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    //consente di aggiungere una categoria
    @PostMapping("categoria")
    public ResponseEntity<Categoria> addCategoria(@RequestBody Categoria categoria) {
        return categoriaService.addCategoria(categoria);
    }

    //restituisce tutte le categorie
    @GetMapping("categoria")
    public ResponseEntity<List<Categoria>> getAllCategoria() {
        return categoriaService.getAllCategoria();
    }

}
