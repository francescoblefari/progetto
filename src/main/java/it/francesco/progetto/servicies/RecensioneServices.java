package it.francesco.progetto.servicies;

import it.francesco.progetto.entities.DettaglioOrdine;
import it.francesco.progetto.entities.Prodotto;
import it.francesco.progetto.entities.Recensione;
import it.francesco.progetto.entities.Utente;
import it.francesco.progetto.repositories.DettaglioOrdineRepository;
import it.francesco.progetto.repositories.ProdottoRepository;
import it.francesco.progetto.repositories.RecensioneRepository;
import it.francesco.progetto.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Recensione addCommento(Recensione recensione) {
        return recensioneRepository.save(recensione);
    }

    public List<Recensione> getAllRecensione() {
        return recensioneRepository.findAll();
    }

    public List<Recensione> getRecensioneProdotto(Prodotto p){
        p = prodottoRepository.findById(p.getId()).get();
        return recensioneRepository.findByProdotto(p);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public List<Prodotto> getRecensibiliByUtente(String username){
        List<Prodotto> recensibili = new LinkedList<>();
        Utente u = utenteRepository.findUtenteByUsername(username);
        List<DettaglioOrdine> listDettaglioOrdine = dettaglioOrdineRepository.findAllByAcquisto_Utente(u.getId());

        List<Recensione> recensiti = recensioneRepository.findByUtenteId(u.getId());
        List<Prodotto> prodottiRecensiti = new LinkedList<>();

        for(Recensione r: recensiti){
            prodottiRecensiti.add(r.getProdotto());
        }

        for(DettaglioOrdine d: listDettaglioOrdine){
            if(!prodottiRecensiti.contains(d.getProdotto()) && !recensibili.contains(d.getProdotto()))
                recensibili.add(d.getProdotto());
        }

        System.out.println(recensibili);
        return recensibili;
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void recensisci(String recensione, Prodotto p, String username){
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
            System.out.println(recensione);
            recensioneRepository.save(r);
        }
    }

}
