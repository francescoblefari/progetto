package it.francesco.progetto.servicies;

import it.francesco.progetto.entities.DettaglioOrdine;
import it.francesco.progetto.entities.Prodotto;
import it.francesco.progetto.entities.Recensione;
import it.francesco.progetto.entities.Utente;
import it.francesco.progetto.repositories.DettaglioOrdineRepository;
import it.francesco.progetto.repositories.ProdottoRepository;
import it.francesco.progetto.repositories.RecensioneRepository;
import it.francesco.progetto.repositories.UtenteRepository;
import it.francesco.progetto.supports.Invio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Service
public class RecensioneServices {

    @Autowired
    private RecensioneRepository recensioneRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private DettaglioOrdineRepository dettaglioOrdineRepository;

    @Autowired
    private ProdottoRepository prodottoRepository;

    public ResponseEntity<Recensione> addCommento(Recensione recensione) {
        return new ResponseEntity<>(recensioneRepository.save(recensione), HttpStatus.OK);
    }

    public ResponseEntity<List<Recensione>> getAllRecensione() {
        return new ResponseEntity<>(recensioneRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<List<Recensione>> getRecensioneProdotto(Prodotto p){
        p = prodottoRepository.findById(p.getId()).get();
        return new ResponseEntity<>(recensioneRepository.findByProdotto(p), HttpStatus.OK);
    }

    /*
    * dato un utente, visualizza per tutti i prodotti
    * che ha acquistato quelli che non ha ancora recensito
    * */
    @Transactional
    public ResponseEntity<List<Prodotto>> getRecensibiliByUtente(String username){
        List<Prodotto> recensibili = new LinkedList<>();
        Utente u = utenteRepository.findUtenteByUsername(username);
        List<DettaglioOrdine> listDettaglioOrdine = dettaglioOrdineRepository.findAllByAcquisto_Utente(u.getId());

        List<Recensione> recensioni = recensioneRepository.findByUtenteId(u.getId());
        List<Prodotto> prodottiRecensiti = new LinkedList<>();

        for(Recensione r: recensioni){
            prodottiRecensiti.add(r.getProdotto());
        }

        for(DettaglioOrdine d: listDettaglioOrdine){
            if(!prodottiRecensiti.contains(d.getProdotto()) && !recensibili.contains(d.getProdotto()))
                recensibili.add(d.getProdotto());
        }

        return new ResponseEntity<>(recensibili, HttpStatus.OK);
    }

    @Transactional
    public void recensisci(Invio invio){
        Prodotto p = invio.getProdotto();
        String recensione = invio.getValore();
        String username = invio.getUsername();
        Utente u = utenteRepository.findUtenteByUsername(username);
        p = prodottoRepository.findById(p.getId()).get();
        List<Recensione> recensioni = recensioneRepository.findAll();
        boolean trovato = false;
        for(Recensione re: recensioni){
            if(re.getUtente()==u && re.getProdotto()==p)
            {trovato = true;break;}
        }
        if(!trovato) {
            Recensione r = new Recensione();
            r.setRelazione(recensione);
            r.setProdotto(p);
            r.setUtente(u);
            recensioneRepository.save(r);
        }
    }

}
