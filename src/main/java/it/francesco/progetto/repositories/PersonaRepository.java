package it.francesco.progetto.repositories;

import it.francesco.progetto.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonaRepository extends JpaRepository<Utente, String> {
}
