package it.francesco.progetto.servicies;

import it.francesco.progetto.entities.Acquisto;
import it.francesco.progetto.entities.DettaglioOrdine;
import it.francesco.progetto.entities.ProdottoInCarrello;
import it.francesco.progetto.entities.Utente;
import it.francesco.progetto.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class UtenteServicies {

    @Autowired
    private UtenteRepository utenteRepository;

    //primi tre metodi non usati nella web app
    public ResponseEntity<Utente> addPersona(Utente utente) {
        return new ResponseEntity<>(utenteRepository.save(utente), HttpStatus.OK);
    }

    public void addAllPersona(List<Utente> l) {
        utenteRepository.saveAll(l);
    }

    public ResponseEntity<List<Utente>> getAllPersona() {
        return new ResponseEntity<>(utenteRepository.findAll(), HttpStatus.OK);
    }

    @Transactional
    public Utente getPersonaByUsername(String username){
        Utente u = utenteRepository.findUtenteByUsername(username);
        if(username.equals(u.getUsername()))
            return u;
        return null;
    }

    @Transactional(readOnly = true)
    public ResponseEntity<List<ProdottoInCarrello>> listaProdottoInCarrelloByUsername (String username){
        return new ResponseEntity<>(utenteRepository.findUtenteByUsername(username).getProdottoInCarrello(), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<List<DettaglioOrdine>> listDettaglioOrdine(String username){
        Utente u = utenteRepository.findUtenteByUsername(username);
        List<Acquisto> listAcquisto = u.getLista();
        List<DettaglioOrdine> listDettaglioOrdine = new LinkedList<>();
        for(Acquisto a: listAcquisto){
            listDettaglioOrdine.addAll(a.getListaDettaglioOrdine());
        }
        return new ResponseEntity<>(listDettaglioOrdine, HttpStatus.OK);
    }

}