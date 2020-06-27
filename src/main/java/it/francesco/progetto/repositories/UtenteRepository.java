package it.francesco.progetto.repositories;

import it.francesco.progetto.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UtenteRepository extends JpaRepository<Utente, Integer> {

    @Query("SELECT u FROM Utente u WHERE u.username=?1")
    Utente findUtenteByUsername(String username);

    @Query("SELECT u FROM Utente u")
    List<Utente> findAllUtente();
}
