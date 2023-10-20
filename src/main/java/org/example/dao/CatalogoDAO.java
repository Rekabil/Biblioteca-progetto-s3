package org.example.dao;

import org.example.entity.Catalogo;

import javax.persistence.EntityManager;

public class CatalogoDAO {
    private final EntityManager em;

    public CatalogoDAO(EntityManager em) {
        this.em = em;
    }
    public void save(Catalogo catalogo) {

    }
}
