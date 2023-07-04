package com.iftm.api.prontuarioplus.controllers;

import com.iftm.api.prontuarioplus.data.vo.CarteiraIdentidadeVO;
import com.iftm.api.prontuarioplus.services.CarteiraIdentidadeService;
import com.iftm.api.prontuarioplus.services.ConsultaService;
import com.iftm.api.prontuarioplus.data.vo.ConsultaVO;
import com.iftm.api.prontuarioplus.utils.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService service;

    @GetMapping(produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
    public List<ConsultaVO> findAll(){
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
    public ConsultaVO findById(@PathVariable Long id) throws Exception{
        return service.findById(id);
    }

    @PostMapping(consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
            produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    public ConsultaVO save(@RequestBody ConsultaVO consultaVO) throws Exception {
        return service.save(consultaVO);
    }

    @PutMapping(consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
            produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    public ConsultaVO update(@RequestBody ConsultaVO consultaVO) throws Exception {
        return service.update(consultaVO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws Exception {
        service.delete(id);
    }
}
