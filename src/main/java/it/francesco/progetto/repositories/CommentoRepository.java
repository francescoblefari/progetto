package it.francesco.progetto.repositories;

import it.francesco.progetto.entities.Commento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentoRepository extends JpaRepository<Commento, Integer> {
}
