package com.prueba.services;

import com.prueba.models.Empresa;
import com.prueba.models.EmpresaRequest;
import com.prueba.repository.EmpresaRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpresaService {
    private final EmpresaRepository repository;
    private final ModelMapper modelMapper;

    public Empresa crearEmpresa(EmpresaRequest request) {
        Empresa entidat = modelMapper.map(request, Empresa.class);
        return repository.save(entidat);
    }

    public List<Empresa> listarUltimos3() {
        Sort sort = Sort.by(Sort.Direction.DESC, "idEmpresa");
        Pageable pageable = PageRequest.of(0, 3, sort);
        return repository.findAll(pageable).getContent();
    }
}
