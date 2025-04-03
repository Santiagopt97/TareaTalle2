package com.example.demo.models.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "encabezado")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "cliente_id")
    private int idCliente;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "total")
    private double total;

    @Column(name = "descuento")
    private double descuento;

    @OneToOne(mappedBy = "cliente",cascade = CascadeType.ALL, orphanRemoval = true)
    private Cliente cliente;

    public Compra(int id, int idCliente, String fecha, double total, double descuento) {
        this.id = id;
        this.idCliente = idCliente;
        this.fecha = fecha;
        this.total = total;
        this.descuento = descuento;
    }

    public Compra() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    
}
