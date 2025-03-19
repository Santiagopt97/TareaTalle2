package com.example.demo.models.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.Entity.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ClienteDaoImp implements IClienteDao {
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Cliente> findAll() {
        return em.createQuery("from Cliente").getResultList();
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        if (cliente.getId() > 0) {
            em.merge(cliente);
        } else {
            em.persist(cliente);
        }
    }

    @Override
    @Transactional
    public void delete(int id) {
        Cliente cliente = findOne(id);
        if (cliente != null) {
            em.remove(cliente);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findOne(int id) {
        return em.find(Cliente.class, id);
    }

    @Override
    @Transactional
    public void update(Cliente cliente) {
        em.merge(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findByEmail(String email) {
        List<Cliente> clientes = em.createQuery("from Cliente where email = :email", Cliente.class)
                .setParameter("email", email)
                .getResultList();       //getSingleResult()
        return clientes.isEmpty() ? null : clientes.get(0);
    }
}
