package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.DAO.ClienteDaoImp;
import com.example.demo.models.DAO.CompraDaoImp;
import com.example.demo.models.DAO.ProductoDaoImp;
import com.example.demo.models.DAO.DetallesDaoImp;
import com.example.demo.models.Entity.Compra;

@Controller
public class CompraController {
    @Autowired
    CompraDaoImp compraDao;
    @Autowired
    DetallesDaoImp detalleDao; // Replace Detalles with DetallesDaoImp
    @Autowired
    ClienteDaoImp clienteDao;
    @Autowired
    ProductoDaoImp productoDao;

    @GetMapping("/compras")
    public String listarCompras(Model model) {
        model.addAttribute("encab", "Compras");
        model.addAttribute("compras", compraDao.findAll());
        model.addAttribute("titulo", "Compras");
        return "compra/compra";
    }

    @GetMapping("/compras/crear")
    public String crearCompra(Model model) {
        model.addAttribute("encab", "Crear Compra");
        model.addAttribute("clientes", clienteDao.findAll());
        model.addAttribute("productos", productoDao.findAll());
        return "compra/crearCompra";
    }
    @GetMapping("/compras/guardar")
    public String guardarCompra(@RequestParam("clienteId") Long clienteId, @RequestParam("fecha") String fecha,
            @RequestParam("total") double total, @RequestParam("descuento") double descuento) {
        Compra compra = new Compra();
        compra.setFecha(fecha);
        compra.setTotal(total);
        compra.setDescuento(descuento);
        compra.setCliente(clienteDao.search(clienteId.intValue()));
        compraDao.Save(compra);
        return "redirect:/compras"; 
    }
    
}
