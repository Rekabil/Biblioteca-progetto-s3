package org.example.dao;

import org.example.entity.Catalogo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class CatalogoDAO {
    private final EntityManager em;

    public CatalogoDAO(EntityManager em) {
        this.em = em;
    }
    public void save(Catalogo catalogo) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(catalogo);

        transaction.commit();
        System.out.println("Nuovo Libro/Revista inserito");
    }

    public Catalogo findByIsbn(long isbn) {
        return em.find(Catalogo.class, isbn);
    }

    public void deleteByIsbn(long isbn) {
        Catalogo found =em.find(Catalogo.class, isbn);

        if (found != null) {
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("Libro/Revista Rimosso Dalla Biblioteca");
        } else {
            System.out.println("Libro/Revista Non Essiste Nella Biblioteca");
        }
    }

public List<Catalogo> findByYear(int anno) {
    TypedQuery<Catalogo> getCatalogo = em.createQuery("SELECT c FROM Catalogo c WHERE c.anno = :anno", Catalogo.class);
    getCatalogo.setParameter("anno" , anno);
    return getCatalogo.getResultList();
}

    public List<Catalogo> findByAuthor(String autore) {
        TypedQuery<Catalogo> getCatalogo = em.createQuery("SELECT c FROM Catalogo c WHERE c.autore = :autore", Catalogo.class);
        getCatalogo.setParameter("autore" , autore);
        return getCatalogo.getResultList();
    }
    public List<Catalogo> findByTitolo(String titolo) {
        TypedQuery<Catalogo> getCatalogo = em.createQuery("SELECT c FROM Catalogo c WHERE LOWER(c.titolo) LIKE LOWER(CONCAT(:titolo, '%'))", Catalogo.class);
        getCatalogo.setParameter("titolo" , titolo);
        return getCatalogo.getResultList();
    }


}
