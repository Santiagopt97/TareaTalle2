package com.example.demo.models.DAO;

import java.util.List;

import com.example.demo.models.Entity.Detalles;

public interface IDetallesDao {

    public List<Detalles> findAll();
    
    public Detalles search(Long id);

    public void Save(Detalles detalle);

    public void update(Detalles detalle);

    public void delete(Detalles detalle);
}
