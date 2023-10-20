package org.example.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("Libri")
public class Libri extends Catalogo {

    private String autore;
    private String genere;

    public Libri(String titolo, LocalDate anno, int numPagine, String autore, String genere) {
        super(titolo, anno, numPagine);
        this.autore = autore;
        this.genere= genere;
    }

    public String getGenere() {
        return genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    @Override
    public String toString() {
        return "Libri{" +
                "autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                '}' + super.toString();
    }
}
