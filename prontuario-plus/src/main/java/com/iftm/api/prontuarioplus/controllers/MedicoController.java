package com.iftm.api.prontuarioplus.controllers;

import com.iftm.api.prontuarioplus.services.MedicoService;
import com.iftm.api.prontuarioplus.vo.MedicoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    private final MedicoService medicoService;

    @Autowired
    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping
    public ResponseEntity<List<MedicoVO>> getAllMedicos() {
        List<MedicoVO> medicos = medicoService.findAll();
        return ResponseEntity.ok(medicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoVO> getMedicoById(@PathVariable("id") Long id) {
        MedicoVO medico = medicoService.findById(id);
        if (medico != null) {
            return ResponseEntity.ok(medico);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<MedicoVO> createMedico(@RequestBody MedicoVO medicoVO) {
        MedicoVO novoMedico = medicoService.save(medicoVO);
        if (novoMedico != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(novoMedico);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicoVO> updateMedico(@PathVariable("id") Long id, @RequestBody MedicoVO medicoVO) {
        medicoVO.setId(id); // Set the ID from the path variable into the MedicoVO object
        MedicoVO updatedMedico = medicoService.update(medicoVO);
        if (updatedMedico != null) {
            return ResponseEntity.ok(updatedMedico);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMedico(@PathVariable("id") Long id) {
        String message = medicoService.delete(id);
        if (message.contains("deleted")) {
            return ResponseEntity.ok(message);
        }
        return ResponseEntity.notFound().build();
    }
}
