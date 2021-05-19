package it.francesco.progetto.servicies;

import it.francesco.progetto.entities.DettaglioOrdine;
import it.francesco.progetto.entities.Utente;
import it.francesco.progetto.repositories.DettaglioOrdineRepository;
import it.francesco.progetto.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DettaglioOrdineService {

    @Autowired
    private DettaglioOrdineRepository dettaglioOrdineRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    /*
    * analogamente avrei potuto lavorare direttamente con gli oggetti dato che in utente mi memorizzo una lista
    * di acquisti ed in ogni acquisto, memorizzo una lista di dettaglio ordine
    * */
    @Transactional
    public ResponseEntity<List<DettaglioOrdine>> getAllByUsernameUtente(String username) {
        Utente u = utenteRepository.findUtenteByUsername(username);
        return new ResponseEntity<>(dettaglioOrdineRepository.findAllByAcquisto_Utente(u.getId()), HttpStatus.OK);
    }


}
