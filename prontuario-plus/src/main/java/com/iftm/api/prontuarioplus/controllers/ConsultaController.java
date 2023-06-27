package com.iftm.api.prontuarioplus.controllers;

import com.iftm.api.prontuarioplus.services.ConsultaService;
import com.iftm.api.prontuarioplus.vo.ConsultaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService service;

    @PostMapping
    public ResponseEntity<ConsultaVO> scheduleConsulta(@RequestBody ConsultaVO consultaVO) {
        ConsultaVO savedConsulta = service.save(consultaVO);
        if (savedConsulta == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(savedConsulta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaVO> getConsultaById(@PathVariable("id") Long id) {
        ConsultaVO foundConsulta = service.findById(id);
        if (foundConsulta == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundConsulta);
    }

    @GetMapping
    public ResponseEntity<List<ConsultaVO>> getAllConsultas() {
        return ResponseEntity.ok(service.findAll());
    }
}
