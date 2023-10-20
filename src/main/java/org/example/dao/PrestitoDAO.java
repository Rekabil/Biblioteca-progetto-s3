package org.example.dao;

import org.example.entity.Prestito;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class PrestitoDAO {
    private final EntityManager em;

    public PrestitoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Prestito prestito) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(prestito);

        transaction.commit();
        System.out.println("Nuovo Libro/Revista inserito");
    }

    public List<Prestito> findByUserId(long id) {
        TypedQuery<Prestito> getPrestito = em.createQuery("SELECT p FROM Prestito p WHERE p.utente.id = :id", Prestito.class);
        getPrestito.setParameter("id", id);
        return getPrestito.getResultList();
    }
    public List<Prestito> findByMissingBook() {
        TypedQuery<Prestito> getPrestito = em.createQuery("SELECT p FROM Prestito p WHERE p.dataRestituzioneEffettiva = null", Prestito.class);
        return getPrestito.getResultList();
    }
}
