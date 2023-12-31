package org.example.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "catalogo")
@DiscriminatorColumn(name = "tipo_catalogo")
public abstract class Catalogo {

    @Id
    @GeneratedValue
    private long isbn;
private String titolo;
private int anno;
private int numPagine;

public Catalogo() {}

public Catalogo(String titolo, int anno, int numPagine) {
    this.titolo= titolo;


    this.anno = anno;

    this.numPagine = numPagine;
}

    public String getTitolo() {
        return titolo;
    }

    public int getNumPagine() {
        return numPagine;
    }

    public int getAnno() {
        return anno;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public void setNumPagine(int numPagine) {
        this.numPagine = numPagine;
    }

    @Override
    public String toString() {
        return "isbn=" + isbn +
                ", titolo='" + titolo + '\'' +
                ", anno=" + anno +
                ", numPagine=" + numPagine +
                '}';
    }
}
