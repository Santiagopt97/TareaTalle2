package com.example.demo.models.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.Entity.Detalles;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class DetallesDaoImp implements IDetallesDao {

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
        if (detalle.getId() != 0) {
            em.merge(detalle);
        } else {
            em.persist(detalle);
        }
    }

    @Override
    @Transactional
    public void delete(Detalles detalle) {
        em.remove(em.contains(detalle) ? detalle : em.merge(detalle));
    }

    @Override
    @Transactional(readOnly = true)
    public Detalles search(Long id) {
        return em.find(Detalles.class, id);
    }

    @Override
    @Transactional
    public void update(Detalles detalle) {
        em.merge(detalle);
    }

    @Transactional(readOnly = true)
    public Detalles findById(Long id) {
        return em.find(Detalles.class, id);
    }
}
