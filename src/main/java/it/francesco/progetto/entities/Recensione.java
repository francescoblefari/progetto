package it.francesco.progetto.entities;

import javax.persistence.*;

@Entity
public class Recensione {

    private int id;
    private String relazione;
    private Utente utente;
    private Prodotto prodotto;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRelazione() {
        return relazione;
    }

    public void setRelazione(String relazione) {
        this.relazione = relazione;
    }

    @OneToOne
    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    @OneToOne
    public Prodotto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }
}
