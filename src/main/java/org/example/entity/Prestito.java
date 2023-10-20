package org.example.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "prestiti")
public class Prestito {

    @Id
    @GeneratedValue
    private long id;
    @OneToOne(mappedBy = "prestito")
    private Utente utente;
    @OneToOne(mappedBy = "prestito")
    private Catalogo elemento;
    private LocalDate dataInizio;
    private LocalDate dataRestituzionePrevista;
    private LocalDate dataRestituzioneEffettiva;

    public Prestito(Utente utente, Catalogo elemento, LocalDate dataInizio){
        this.utente = utente;
        this.elemento = elemento;
        this.dataInizio = dataInizio;
        this.dataRestituzionePrevista = dataInizio.plusDays(30);
    }

    public long getId() {
        return id;
    }

    public Catalogo getElemento() {
        return elemento;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public LocalDate getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public LocalDate getDataRestituzionePrevista() {
        return dataRestituzionePrevista;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public void setDataRestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    public void setDataRestituzionePrevista(LocalDate dataRestituzionePrevista) {
        this.dataRestituzionePrevista = dataRestituzionePrevista;
    }

    public void setElemento(Catalogo elemento) {
        this.elemento = elemento;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "id=" + id +
                ", utente=" + utente +
                ", elemento=" + elemento +
                ", dataInizio=" + dataInizio +
                ", dataRestituzionePrevista=" + dataRestituzionePrevista +
                ", dataRestituzioneEffettiva=" + dataRestituzioneEffettiva +
                '}';
    }
}
