package br.com.samuel.Models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "CARROS")
@EqualsAndHashCode
public class Carro {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "VALOR", nullable = false)
    private Long valor;
    @Column(name = "COR", nullable = false)
    private String cor;
    @Column(name="MARCA")
    private String marca;
    @Column(name="QUILOMETRAGEM")
    private Long quilometragem;
    @Column(name = "MODELO", nullable = false)
    private String modelo;
    @Column(name = "ANO", nullable = false)
    private int ano;

    public Carro(String marca, String modelo, String cor, Long quilometragem, int ano) {
        this.marca = marca;
        this.quilometragem = quilometragem;
        this.cor = cor;
        this.modelo = modelo;
        this.ano = ano;
    }
}
