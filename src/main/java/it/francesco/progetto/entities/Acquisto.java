package it.francesco.progetto.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.*;

@Entity
public class Acquisto {

    private int idAcquisto;
    private Date data;
    private int utente;
    private List<DettaglioOrdine> listaDettaglioOrdine = new LinkedList<>();

    public Acquisto() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    public int getIdAcquisto() {
        return idAcquisto;
    }

    public void setIdAcquisto(int idAcquisto) {
        this.idAcquisto = idAcquisto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @OneToMany(mappedBy = "acquisto")
    @JsonIgnore
    public List<DettaglioOrdine> getListaDettaglioOrdine() {
        return listaDettaglioOrdine;
    }

    public void setListaDettaglioOrdine(List<DettaglioOrdine> listaDettaglioOrdine) {
        this.listaDettaglioOrdine = listaDettaglioOrdine;
    }

    public int getUtente() {
        return utente;
    }

    public void setUtente(int utente) {
        this.utente = utente;
    }
}
