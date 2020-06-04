package it.francesco.progetto.entities;

import javax.persistence.*;
import java.util.*;

@Entity
public class Acquisto {

    private int idAcquisto;
    private Date data;
    private List<DettaglioOrdine> listaDettaglioOrdine = new LinkedList<>();

    public Acquisto() {
    }

    @Id @GeneratedValue
    public int getIdAcquisto() {
        return idAcquisto;
    }

    public void setIdAcquisto(int idAcquisto) {
        this.idAcquisto = idAcquisto;
    }

    public Date getData() {return data;}

    public void setData(Date data) {this.data = data;}

    @OneToMany(mappedBy = "acquisto")
    public List<DettaglioOrdine> getListaDettaglioOrdine() {
        return listaDettaglioOrdine;
    }

    public void setListaDettaglioOrdine(List<DettaglioOrdine> listaDettaglioOrdine) {
        this.listaDettaglioOrdine = listaDettaglioOrdine;
    }
}
