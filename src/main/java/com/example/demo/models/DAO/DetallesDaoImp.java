package com.example.demo.models.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.Entity.Cliente;
import com.example.demo.models.Entity.Detalles;
import com.example.demo.models.Entity.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class DetallesDaoImp implements IdetallesDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Detalles> findAll() {
        return em.createQuery("from Detalle").getResultList();
    }

    @Override
    @Transactional
    public void Save(Detalles detalle) {
        em.persist(detalle);
    }
    @Override
    @Transactional
    public void delete(Detalles detalle) {
        Detalles detalle = findOne(detalle);
        if (producto != null) {
            em.remove(producto);
        }
    }

}
