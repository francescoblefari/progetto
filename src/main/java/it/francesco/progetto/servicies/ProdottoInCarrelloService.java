package it.francesco.progetto.servicies;

import it.francesco.progetto.entities.*;
import it.francesco.progetto.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class ProdottoInCarrelloService {
    @Autowired
    public ProdottoInCarrelloRepository prodottoInCarrelloRepository;

    @Autowired
    private ProdottoRepository prodottoRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private DettaglioOrdineRepository dettaglioOrdineRepository;

    @Autowired
    private AcquistoRepository acquistoRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<List<ProdottoInCarrello>> getAllProdottiInCarrello() {
        return new ResponseEntity<>(prodottoInCarrelloRepository.findAll(), HttpStatus.OK);
    }

    @Transactional
    public void addProdottoInCarrello(ProdottoInCarrello p) {
        Utente u = utenteRepository.findUtenteByUsername(p.getUtente().getUsername());
        Prodotto prodotto = prodottoRepository.findById(p.getProdotto().getId()).get();
        ProdottoInCarrello pIcPresente = prodottoInCarrelloRepository.findByProdottoAndUtente(prodotto, u);
        ProdottoInCarrello pIc = null;

        if(prodotto.getQta()>0)
            if (pIcPresente == null) {
                pIc = new ProdottoInCarrello();
                pIc.setProdotto(prodotto);
                pIc.setQta(1);
                pIc.setUtente(u);
                pIc.setPrezzo(prodotto.getPrezzo());
                prodottoInCarrelloRepository.save(pIc);
                u.getProdottoInCarrello().add(pIc);
            } else {
                if (pIcPresente.getQta() + 1 <= prodotto.getQta()) {

                    pIcPresente.setQta(pIcPresente.getQta()+1);
                    pIcPresente.setPrezzo(prodotto.getPrezzo()*pIcPresente.getQta());
                    u.getProdottoInCarrello().add(pIcPresente);

                    /*
                    pIc.setQta(pIcPresente.getQta() + 1);
                    pIc.setPrezzo(prodotto.getPrezzo() * pIc.getQta());
                    pIc.setUtente(u);
                    pIc.setProdotto(prodotto);
                    prodottoInCarrelloRepository.delete(pIcPresente);
                    prodottoInCarrelloRepository.save(pIc);
                    u.getProdottoInCarrello().remove(pIcPresente);
                    u.getProdottoInCarrello().add(pIc);
                    */
                }
        }
    }

    @Transactional
    public void deleteProdottoInCarrello(ProdottoInCarrello p) {
        prodottoInCarrelloRepository.delete(p);
    }

    @Transactional(readOnly=true)
    public ResponseEntity<ProdottoInCarrello> findProdottoInCarrelloById(int id) {
        return new ResponseEntity<>(prodottoInCarrelloRepository.findById(id).get(), HttpStatus.OK);
    }

    @Transactional(readOnly=true)
    public ResponseEntity<List<ProdottoInCarrello>> getProdottiInCarrelloByUsername(String username){
        Utente u1 = utenteRepository.findUtenteByUsername(username);
        return new ResponseEntity<>(u1.getProdottoInCarrello(),HttpStatus.OK);
    }

    @Transactional
    public void acquistaCarrello(String username) {
        Utente utente = utenteRepository.findUtenteByUsername(username);
        List<ProdottoInCarrello> list = utente.getProdottoInCarrello();

        List<DettaglioOrdine> tmpDettaglioOrdine = new LinkedList<>();
        List<ProdottoInCarrello> acquistati = new LinkedList<>();
        Acquisto a = new Acquisto();
        a.setData(new Date());

        for (ProdottoInCarrello p : list) {
            Prodotto pDB = prodottoRepository.findById(p.getProdotto().getId()).get();
            if(pDB.getQta()>=p.getQta()){
                pDB.setQta(pDB.getQta() - p.getQta());

                DettaglioOrdine d = new DettaglioOrdine();
                d.setAcquisto(a);
                d.setQta(p.getQta());
                d.setPrezzo(p.getPrezzo());
                d.setProdotto(p.getProdotto());
                tmpDettaglioOrdine.add(d);
                acquistati.add(p);

                dettaglioOrdineRepository.save(d);
                prodottoInCarrelloRepository.delete(p);
            }
        }
        list.removeAll(acquistati);
        a.setUtente(utente.getId());
        a.setListaDettaglioOrdine(tmpDettaglioOrdine);
        utente.getLista().add(a);
        acquistoRepository.save(a);
    }
}
