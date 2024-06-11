package com.curso.api2curso.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_possantes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Possante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "modelo", nullable = false, length = 50)
    private String modelo;
    @Column(name = "ano", nullable = false, length = 4)
    private Integer ano;
    @Column(name = "placa", nullable = false, length = 8)
    private String placa;
    @Column(name = "cor", nullable = false, length = 15)
    private String cor;


    @Override
    public String toString() {
        return String.format( "Possante cadastrado : "
                + "ID = " + id
                + ", Modelo = " + modelo
                + ", Ano = " + ano
                + ", Placa = " + placa
                + ", Cor = " + cor);

    }
}
