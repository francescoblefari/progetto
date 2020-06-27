package it.francesco.progetto.servicies;

import it.francesco.progetto.entities.*;
import it.francesco.progetto.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
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


    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public List<ProdottoInCarrello> getAllProdottiInCarrello() {
        return prodottoInCarrelloRepository.findAll();
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public ProdottoInCarrello addProdottoInCarrello(ProdottoInCarrello p) {
        Utente u = utenteRepository.findUtenteByUsername(p.getUtente().getUsername());
        Prodotto prodotto = prodottoRepository.findById(p.getProdotto().getId()).get();
        ProdottoInCarrello pIcPresente = prodottoInCarrelloRepository.findByProdottoAndUtente(prodotto, u);
        ProdottoInCarrello pIc = new ProdottoInCarrello();

        if(prodotto.getQta()>0)
            if (pIcPresente == null) {
                pIc.setProdotto(prodotto);
                pIc.setQta(1);
                pIc.setUtente(u);
                pIc.setPrezzo(prodotto.getPrezzo());
                prodottoInCarrelloRepository.save(pIc);
                u.getProdottoInCarrello().add(pIc);
                return pIc;
            } else {
                if (pIcPresente.getQta() + 1 <= prodotto.getQta()) {
                    pIc.setQta(pIcPresente.getQta() + 1);
                    pIc.setPrezzo(prodotto.getPrezzo() * pIc.getQta());
                    pIc.setUtente(u);
                    pIc.setProdotto(prodotto);
                    prodottoInCarrelloRepository.delete(pIcPresente);
                    prodottoInCarrelloRepository.save(pIc);
                    u.getProdottoInCarrello().remove(pIcPresente);
                    u.getProdottoInCarrello().add(pIc);
                    return pIc;
                }
            return pIcPresente;
        }
        return null;
    }

    public void deleteProdottoInCarrello(ProdottoInCarrello p) {
        prodottoInCarrelloRepository.delete(p);
    }

    public ProdottoInCarrello findProdottoInCarrelloById(int id) {
        return prodottoInCarrelloRepository.findById(id).get();
    }

    public List<ProdottoInCarrello> getProdottiInCarrelloByUsername(String username){
        Utente u1 = utenteRepository.findUtenteByUsername(username);
        System.out.println(u1.getProdottoInCarrello());
        return u1.getProdottoInCarrello();
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public List<DettaglioOrdine> acquistaCarrello(String username) {
        Utente utente = utenteRepository.findUtenteByUsername(username);
        List<ProdottoInCarrello> list = utente.getProdottoInCarrello();

        List<DettaglioOrdine> acquistabili = new LinkedList<>();
        List<ProdottoInCarrello> acquistati = new LinkedList<>();
        Acquisto a = new Acquisto();
        a.setData(new Date());

        System.out.println(list);
        for (ProdottoInCarrello p : list) {
            Prodotto pDB = prodottoRepository.findById(p.getProdotto().getId()).get();
            pDB.setQta(pDB.getQta() - p.getQta());

            DettaglioOrdine d = new DettaglioOrdine();
            d.setAcquisto(a);
            d.setQta(p.getQta());
            d.setPrezzo(p.getPrezzo());
            d.setProdotto(p.getProdotto());

            acquistabili.add(d);
            acquistati.add(p);

            prodottoRepository.save(pDB);
            dettaglioOrdineRepository.save(d);
            prodottoInCarrelloRepository.delete(p);
        }

        list.removeAll(acquistati);
        a.setUtente(utente.getId());
        a.setListaDettaglioOrdine(acquistabili);
        utente.getLista().add(a);
        acquistoRepository.save(a);
        return acquistabili;
    }
}
