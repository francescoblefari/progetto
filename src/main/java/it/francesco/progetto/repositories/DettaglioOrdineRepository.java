package it.francesco.progetto.repositories;

import it.francesco.progetto.entities.DettaglioOrdine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DettaglioOrdineRepository extends JpaRepository<DettaglioOrdine, Integer> {

    @Query( "SELECT d " +
            "FROM DettaglioOrdine d, Acquisto a " +
            "WHERE d.acquisto.idAcquisto = a.idAcquisto AND a.utente = ?1" )
    List<DettaglioOrdine> findAllByAcquisto_Utente(int id);

}
