package com.example.demo.models.Entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Encabezado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "descuento")
    private double descTotal;

    @Column(name = "total")
    private double total;

    @ManyToOne
    @JoinColumn(name = "cliente_id", foreignKey = @jakarta.persistence.ForeignKey(name = "fk_cliente"))
    private Cliente cliente;

    @OneToMany(mappedBy = "encabezado", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Detalles> detalles;

    public Encabezado() {
    }

    public Encabezado(int id, Date fecha, double descTotal, double total, Cliente cliente) {
        this.id = id;
        this.fecha = fecha;
        this.descTotal = descTotal;
        this.total = total;
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getDescTotal() {
        return descTotal;
    }

    public void setDescTotal(double descTotal) {
        this.descTotal = descTotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Detalles> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<Detalles> detalles) {
        this.detalles = detalles;
    }
}
