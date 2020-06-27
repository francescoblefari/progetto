package it.francesco.progetto.conrollers;

import it.francesco.progetto.entities.Categoria;
import it.francesco.progetto.servicies.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping("categoria")
    public Categoria addCategoria(@RequestBody Categoria categoria) {
        return categoriaService.addCategoria(categoria);
    }

    @GetMapping("categoria")
    public List<Categoria> getAllCategoria() {
        return categoriaService.getAllCategoria();
    }

}
