package com.example.demo.models.DAO;

import java.util.List;

import com.example.demo.models.Entity.Producto;

public interface IProductoDao {
    public List<Producto> findAll();
    public void save(Producto producto);
    public void delete(int id);
    public Producto findOne(int id);
    public void update(Producto producto);
}
