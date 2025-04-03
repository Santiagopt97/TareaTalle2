package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.DAO.IClienteDao;
import com.example.demo.models.Entity.Cliente;

@Controller
public class LoginController {

    @Autowired
    private IClienteDao clienteDao;

    @GetMapping({"/login","/",""})
    public String login(Model model) {
        model.addAttribute("titulo", "Login");
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        Cliente cliente = clienteDao.findByEmailAndPassword(email, password);
        if (cliente == null) {
            return "redirect:/login?error=Correo o contrasena incorrectos";
        }
        return "redirect:/productos";
    }

}
