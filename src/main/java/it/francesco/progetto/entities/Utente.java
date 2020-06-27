package it.francesco.progetto.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "utente")
public class Utente {

    private int id;
    private String nome;
    private String cognome;
    private String username;
    private String password;
    private String email;
    private List<Acquisto> lista;
    private List<ProdottoInCarrello> prodottoInCarrello;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
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

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    @Column(unique = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "utente")
    public List<Acquisto> getLista() {
        return lista;
    }

    public void setLista(List<Acquisto> lista) {
        this.lista = lista;
    }

    @OneToMany( cascade = CascadeType.ALL, mappedBy = "utente")
    @JsonIgnore
    public List<ProdottoInCarrello> getProdottoInCarrello() { return prodottoInCarrello; }

    public void setProdottoInCarrello(List<ProdottoInCarrello> prodottoInCarrello) {
        this.prodottoInCarrello = prodottoInCarrello;
    }
}
