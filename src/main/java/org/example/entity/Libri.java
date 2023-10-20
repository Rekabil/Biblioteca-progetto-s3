package org.example.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Libri")
public class Libri extends Catalogo {

    public Libri() {}
    private String autore;
    private String genere;

    public Libri(String titolo, int anno, int numPagine, String autore, String genere) {
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
                ", " + super.toString();
    }
}
