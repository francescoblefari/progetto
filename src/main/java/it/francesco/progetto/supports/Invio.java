package it.francesco.progetto.supports;

import it.francesco.progetto.entities.Prodotto;

public class Invio {

    private String valore;
    private Prodotto prodotto;
    private String username;

    public String getValore() {
        return valore;
    }

    public void setValore(String valore) {
        this.valore = valore;
    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
