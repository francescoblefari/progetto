package it.francesco.progetto.entities;

import javax.persistence.*;

//entity commento
@Entity
public class Commento {

    private int id;
    private String nome;
    private String relazione;
    private Utente utente;
    private Prodotto prodotto;

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    @ManyToOne
    public Prodotto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }
}
