package br.com.samuel.Models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;

@Entity
@Getter
@Table(name="CLIENTE")
@EqualsAndHashCode
public class Vendedor {
    @Id
    @GeneratedValue
    private long id;
    @OneToMany
    @JoinColumn(name = "OFERTAS")
    private ArrayList<Oferta> ofertas;
    @Column(name = "NOME", nullable = false)
    private String nome;
    @Column(name = "ENDERECO", nullable = false)
    private String endereco;
    @Column(name = "CPF", nullable = false)
    private String cpf;

    public Vendedor(String nome, String endereco, String cpf){
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
    }

    public void adicionaOferta(Oferta oferta){
        ofertas.add(oferta);
    }
}
