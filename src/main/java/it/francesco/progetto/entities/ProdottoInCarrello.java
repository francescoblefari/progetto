package it.francesco.progetto.entities;

import it.francesco.progetto.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
public class ProdottoInCarrello {

    private int id;
    private double prezzo;
    private int qta;
    private Prodotto prodotto;
    private Utente utente;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public int getQta() {
        return qta;
    }

    public void setQta(int qta) {
        this.qta = qta;
    }

    @OneToOne
    public Prodotto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    @ManyToOne
    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    @Override
    public String toString() {
        return "ProdottiInCarrello{" +
                "id=" + id +
                ", prezzo=" + prezzo +
                ", qta=" + qta +
                ", prodotto=" + prodotto +
                ", utente=" + utente +
                '}';
    }
}
