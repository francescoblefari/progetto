package it.francesco.progetto.repositories;

import it.francesco.progetto.entities.ProdottoInCarrello;
import it.francesco.progetto.entities.Prodotto;
import it.francesco.progetto.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdottoInCarrelloRepository extends JpaRepository<ProdottoInCarrello, Integer> {

    @Query("SELECT p FROM ProdottoInCarrello p WHERE p.prodotto=?1 AND p.utente=?2")
    ProdottoInCarrello findByProdottoAndUtente(Prodotto p, Utente u);

}
