package com.prueba.models;

import lombok.Data;

@Data
public class EmpresaRequest {
    private String ruc;
    private String razonSocial;
    private String direccion;
    private Boolean estado;
}
