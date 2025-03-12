package com.example.demo.controllers;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.models.DAO.IClienteDao;
import com.example.demo.models.Entity.Cliente;

@Controller
public class ClienteController {

    @Autowired
    private IClienteDao clienteDao;

    @GetMapping({"/listar","/",""})
    public String listar(Model model) {
        model.addAttribute("titulo", "listado de clientes");
        model.addAttribute("clientes", clienteDao.findAll());
        return "listar";
    }

    @GetMapping("/form")
    public String crear(Model model) {
        Cliente cliente = new Cliente();
        model.addAttribute("cliente", cliente);
        model.addAttribute("titulo", "Formulario de Cliente");
        return "form";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        Cliente cliente = clienteDao.findOne(id);
        if (cliente == null) {
            return "redirect:/listar?error=Cliente no encontrado";
        }
        model.addAttribute("cliente", cliente);
        model.addAttribute("titulo", "Editar Cliente");
        return "form";
    }

    @PostMapping("/form")
    public String guardar(@RequestParam(required = false) Long id, @RequestParam String nombre,
            @RequestParam String apellido, @RequestParam String email, @RequestParam Date createAt) {
        Cliente cliente;
        if (id != null && id > 0) {
            cliente = clienteDao.findOne(id.intValue());
            if (cliente == null) {
                return "redirect:/listar?error=Cliente no encontrado";
            }
        } else {
            cliente = new Cliente();
        }
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setEmail(email);
        cliente.setCreateAt(createAt);
        clienteDao.save(cliente);
        return "redirect:/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        Cliente cliente = clienteDao.findOne(id);
        if (cliente != null) {
            clienteDao.delete(id);
        }
        return "redirect:/listar";
    }
}
