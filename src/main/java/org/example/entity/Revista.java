package org.example.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("Revista")
public class Revista extends Catalogo{

    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;

    public Revista() {}
    public Revista(String titolo, int anno, int numPagine, Periodicita periodicita) {
        super(titolo, anno, numPagine);
        this.periodicita = periodicita;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "Revista{" +
                "periodicita=" + periodicita +
                ", " + super.toString();
    }
}
