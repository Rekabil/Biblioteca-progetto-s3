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
            System.out.println("Hello");

//            Libri libro = new Libri("i promessi sposi", 1857, 987, "Alessandro Manzoni" , "Romanzo");
//            Revista revista = new Revista("Guide" , 2015, 75, Periodicita.MENSILE);
//
//            catalogoDAO.save(libro);
//            catalogoDAO.save(revista);
//System.out.println(catalogoDAO.findByTitolo("i"));


        //    Utente utente = new Utente("Remzi", "Bilgen" , LocalDate.of(2002,4,10));

//            Prestito prestito= new Prestito(utenteDAO.findById(6) , catalogoDAO.findByIsbn(4) , LocalDate.of(2001, 2, 3));
//prestitoDAO.save(prestito);

          System.out.println(prestitoDAO.findByUserId(6));
            System.out.println(prestitoDAO.findByMissingBook());


        } catch (Exception ex){
            System.err.println(ex.getMessage());
        }finally {
            em.close();
            emf.close();
        }

    }


}
