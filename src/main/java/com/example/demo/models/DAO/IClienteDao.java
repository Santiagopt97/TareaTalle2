package com.example.demo.models.DAO;

import java.util.List;

import com.example.demo.models.Entity.Cliente;

public interface IClienteDao {
    public List<Cliente> findAll();
    public void save(Cliente cliente);
    public void delete(int id);
    public Cliente findOne(int id);
    public void update(Cliente cliente);
    public Cliente findByEmail(String email);
    public Cliente findByEmailAndPassword(String email, String password);
}
