package it.francesco.progetto.repositories;

import it.francesco.progetto.entities.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdottoRepository extends JpaRepository<Prodotto, Integer> {
}
