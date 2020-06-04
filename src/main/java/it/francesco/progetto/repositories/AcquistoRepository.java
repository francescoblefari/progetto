package it.francesco.progetto.repositories;

import it.francesco.progetto.entities.Acquisto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcquistoRepository extends JpaRepository<Acquisto, Integer> {
}
