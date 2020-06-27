package it.francesco.progetto.servicies;

import it.francesco.progetto.entities.DettaglioOrdine;
import it.francesco.progetto.entities.Utente;
import it.francesco.progetto.repositories.DettaglioOrdineRepository;
import it.francesco.progetto.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DettaglioOrdineService {

    @Autowired
    private DettaglioOrdineRepository dettaglioOrdineRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    public List<DettaglioOrdine> getAllByIdUtente(String username) {
        Utente u = utenteRepository.findUtenteByUsername(username);
        return dettaglioOrdineRepository.findAllByAcquisto_Utente(u.getId());
    }


}
