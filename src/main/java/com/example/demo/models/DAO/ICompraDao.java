package com.example.demo.models.DAO;

import java.util.List;

import com.example.demo.models.Entity.Compra;

public interface ICompraDao {

    public List<Compra> findAll();

    public void Save(Compra compra);

    public Compra search(Long id);

    public void delete(Compra compra);

    public void update(Compra compra);
    
}
