package com.example.demo.models.DAO;

import java.util.List;

import com.example.demo.models.Entity.Compra;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class CompraDaoImp implements ICompraDao {
    
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Compra> findAll() {
        return em.createQuery("from Compra").getResultList();
    }

    @Override
    @Transactional
    public void Save(Compra compra) {
        if (compra.getId() != 0) {
            em.merge(compra);
        } else {
            em.persist(compra);
        }
    }

    @Override
    @Transactional
    public Compra search(Long id) {
        return em.find(Compra.class, id);
    }

    @Override
    @Transactional
    public void delete(Compra compra) {
        em.remove(em.contains(compra) ? compra : em.merge(compra));
    }
    @Override
    @Transactional
    public void update(Compra compra) {
        em.merge(compra);
    }
    
}
