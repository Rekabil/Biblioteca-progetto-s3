package org.example;

import java.sql.SQLException;
import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.example.dao.CatalogoDAO;
import org.example.dao.JpaUtils;
import org.example.dao.PrestitoDAO;
import org.example.dao.UtenteDAO;
import org.example.entity.*;
import org.h2.tools.Server;

public class Application {
private static final EntityManagerFactory emf = JpaUtils.getEntityManagerFactory();
    public static void main(String[] args) throws SQLException {
        EntityManager em = emf.createEntityManager();

        try {
            UtenteDAO utenteDAO = new UtenteDAO(em);
            CatalogoDAO catalogoDAO =new CatalogoDAO(em);
            PrestitoDAO prestitoDAO = new PrestitoDAO(em);



System.out.println("Salva Elemento");
            Libri libro = new Libri("i promessi sposi", 1857, 987, "Alessandro Manzoni" , "Romanzo");
catalogoDAO.save(libro);
            System.out.println("Rimuovere un Elemento");
catalogoDAO.deleteByIsbn(15);
            System.out.println("Ricerca per ISBN");
            System.out.println(catalogoDAO.findByIsbn(1));
            System.out.println("Ricerca per anno publicazione");
            System.out.println(catalogoDAO.findByYear(1857));
            System.out.println("Ricerca per titolo o parte di esso");
            System.out.println(catalogoDAO.findByTitolo("i"));
            System.out.println("Ricerca prestito tramite id utente");
            System.out.println(prestitoDAO.findByUserId(6));
            System.out.println("Ricerca di tutti i prestiti scaduti e non ancora restituiti");
            System.out.println(prestitoDAO.findByMissingBook());


        } catch (Exception ex){
            System.err.println(ex.getMessage());
        }finally {
            em.close();
            emf.close();
        }

    }


}
