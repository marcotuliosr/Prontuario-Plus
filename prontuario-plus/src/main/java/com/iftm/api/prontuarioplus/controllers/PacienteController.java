package com.iftm.api.prontuarioplus.controllers;

import com.iftm.api.prontuarioplus.vo.PacienteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.iftm.api.prontuarioplus.services.PacienteService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @GetMapping
    public List<PacienteVO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public PacienteVO findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping
    public PacienteVO save(@RequestBody PacienteVO pacienteVO) {
        return service.save(pacienteVO);
    }

    @PutMapping("/{id}")
    public PacienteVO update(@PathVariable("id") Long id, @RequestBody PacienteVO pacienteVO) {
        pacienteVO.setId(id);
        return service.update(pacienteVO);
    }
}
