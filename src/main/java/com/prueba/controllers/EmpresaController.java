package com.prueba.controllers;

import com.prueba.models.Empresa;
import com.prueba.models.EmpresaRequest;
import com.prueba.services.EmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "v1/empresa")
@RequiredArgsConstructor
public class EmpresaController {
    private final EmpresaService service;

    @PostMapping("/registrar")
    public ResponseEntity<Empresa> registrar(@RequestBody EmpresaRequest empresa) {
        return ResponseEntity.ok(service.crearEmpresa(empresa));
    }

    @GetMapping("/ultimos3")
    public ResponseEntity<List<Empresa>> obtenerUltimos3Registros() {
        return ResponseEntity.ok(service.listarUltimos3());
    }
}
