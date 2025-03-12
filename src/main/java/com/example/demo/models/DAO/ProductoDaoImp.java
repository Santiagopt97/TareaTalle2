package com.example.demo.models.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.Entity.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ProductoDaoImp implements IProductoDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Producto> findAll() {
        return em.createQuery("from Producto").getResultList();
    }

    @Override
    @Transactional
    public void save(Producto producto) {
        if (producto.getId() > 0) {
            em.merge(producto);
        } else {
            em.persist(producto);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Producto findOne(int id) {
        return em.find(Producto.class, id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Producto producto = findOne(id);
        if (producto != null) {
            em.remove(producto);
        }
    }

    @Override
    @Transactional
    public void update(Producto producto) {
        em.merge(producto);
    }

}
