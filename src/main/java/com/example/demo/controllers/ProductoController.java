package com.example.demo.controllers;

import java.sql.Date;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.DAO.IProductoDao;
import com.example.demo.models.Entity.Producto;

@Controller
public class ProductoController {

    @Autowired
    private IProductoDao productoDao;
    private Date currentDate = new Date(Calendar.getInstance().getTime().getTime());

    @GetMapping("/productos")
    public String listar(Model model) {
        model.addAttribute("titulo", "listado de productos");
        model.addAttribute("productos", productoDao.findAll());
        return "producto/listar";
    }

    @GetMapping("/productos/{id}")
    public String eliminar(@PathVariable Integer id) {
        productoDao.delete(id);
        return "redirect:/productos";
    }   

    @GetMapping("/productos/crear")
    public String crear(Model model) {
        Producto producto = new Producto();
        model.addAttribute("producto", producto);
        model.addAttribute("titulo", "Formulario de Producto");
        return "producto/crear";
    }

    @GetMapping("/productos/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Producto producto = productoDao.findOne(id);
        if (producto == null) {
            return "redirect:/productos?error=Producto no encontrado";
        }
        model.addAttribute("producto", producto);
        model.addAttribute("titulo", "Editar Producto");
        return "producto/crear";
    }

    @PostMapping("/productos/guardar")
    public String guardar(@RequestParam(required = false) Integer id, @RequestParam String nombre, @RequestParam Integer stock, @RequestParam double precio, @RequestParam Date createAt) {
        if (precio < 0) {
            return "redirect:/productos?error=El precio no puede ser negativo";
        }
        if (stock < 0) {
            return "redirect:/productos?error=El stock no puede ser negativo";
        }
        if (createAt.after(currentDate)) {
            return "redirect:/productos?error=La fecha de creación no puede ser futura";
        }
        
        Producto producto;
        if (id != null && id > 0) {
            producto = productoDao.findOne(id);
            if (producto == null) {
                return "redirect:/productos?error=Producto no encontrado";
            }
        } else {
            producto = new Producto();
        }
        producto.setNombre(nombre);
        producto.setStock(stock);
        producto.setPrecio(precio);
        producto.setCreateAt(createAt);
        productoDao.save(producto);
        return "redirect:/productos";
    }

    

}
