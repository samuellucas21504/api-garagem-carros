package br.com.samuel.Models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
@Entity
@Getter
@EqualsAndHashCode
@Table(name = "OFERTA")
public class Oferta {
    @Id @GeneratedValue
    private long ID;
    private long Vendedor_ID;
    @ManyToOne
    @JoinColumn(name = "VENDEDOR", nullable = false)
    private Vendedor vendedor;
    @OneToMany
    @JoinColumn(name = "OFERTAS", nullable = false)
    private ArrayList<Carro> carros;

    public Oferta(Vendedor vendedor, Carro carro){
        this.carros.add(carro);
        this.vendedor = vendedor;
        this.Vendedor_ID = vendedor.getId();
    }
}
