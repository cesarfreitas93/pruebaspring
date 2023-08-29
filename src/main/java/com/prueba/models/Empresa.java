package com.prueba.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity(name = "empresa")
@Table
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmpresa;
    @Column(nullable = false)
    private String ruc;
    @Column(nullable = false)
    private String razonSocial;
    @Column(nullable = false)
    private String direccion;
    private Boolean estado;
}
