package it.francesco.progetto.repositories;

import it.francesco.progetto.entities.Prodotto;
import it.francesco.progetto.entities.Recensione;
import it.francesco.progetto.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface RecensioneRepository extends JpaRepository<Recensione, Integer> {

    @Query("SELECT r FROM Recensione r WHERE r.utente.id=?1")
    List<Recensione> findByUtenteId(int id);

    @Query("SELECT r FROM Recensione r WHERE r.prodotto=?1")
    List<Recensione> findByProdotto(Prodotto p);
}
