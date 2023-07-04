package com.iftm.api.prontuarioplus.controllers;

import com.iftm.api.prontuarioplus.data.vo.PacienteVO;
import com.iftm.api.prontuarioplus.data.vo.PacienteVO;
import com.iftm.api.prontuarioplus.services.CarteiraIdentidadeService;
import com.iftm.api.prontuarioplus.utils.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.iftm.api.prontuarioplus.services.PacienteService;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @GetMapping(produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
    public List<PacienteVO> findAll(){
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
    public PacienteVO findById(@PathVariable Long id) throws Exception{
        return service.findById(id);
    }

    @PostMapping(consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
            produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    public PacienteVO save(@RequestBody PacienteVO pacienteVO) throws Exception {
        return service.save(pacienteVO);
    }

    @PutMapping(consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
            produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    public PacienteVO update(@RequestBody PacienteVO pacienteVO) throws Exception {
        return service.update(pacienteVO);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) throws Exception {
        service.delete(id);
    }
}
