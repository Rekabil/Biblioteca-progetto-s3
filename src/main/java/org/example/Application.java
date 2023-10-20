package org.example;

import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.example.dao.CatalogoDAO;
import org.example.dao.JpaUtils;
import org.example.entity.Catalogo;
import org.example.entity.Libri;
import org.example.entity.Periodicita;
import org.example.entity.Revista;
import org.h2.tools.Server;

public class Application {
private static final EntityManagerFactory emf = JpaUtils.getEntityManagerFactory();
    public static void main(String[] args) throws SQLException {
        EntityManager em = emf.createEntityManager();

        try {
            CatalogoDAO catalogoDAO =new CatalogoDAO(em);
            System.out.println("Hello");
//
//            Libri libro = new Libri("i promessi sposi", 1857, 987, "Alessandro Manzoni" , "Romanzo");
//            Revista revista = new Revista("Guide" , 2015, 75, Periodicita.MENSILE);
//
//            catalogoDAO.save(libro);
//            catalogoDAO.save(revista);
            System.out.println(catalogoDAO.findByYear(1857));


        } catch (Exception ex){
            System.err.println(ex.getMessage());
        }finally {
            em.close();
            emf.close();
        }

    }


}
