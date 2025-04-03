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
    @GetMapping("/compras")
    public String crearCompra(@RequestParam(name = "cliente_id", required = true) int id, Model model) {
        model.addAttribute("encab", "Compras");
        model.addAttribute("cliente", clienteDao.search(id));
        model.addAttribute("titulo", "Compra");
        model.addAttribute("titulo2", "Comprador");
        Compra compra = new Compra();
        compraDao.Save(compra);
        model.addAttribute("compra", compra);
        return "compra/compra";
    }
    
    
}
