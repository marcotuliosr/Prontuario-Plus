package com.iftm.api.prontuarioplus.controllers;

import com.iftm.api.prontuarioplus.data.vo.CarteiraIdentidadeVO;
import com.iftm.api.prontuarioplus.models.Medico;
import com.iftm.api.prontuarioplus.services.CarteiraIdentidadeService;
import com.iftm.api.prontuarioplus.services.MedicoService;
import com.iftm.api.prontuarioplus.data.vo.MedicoVO;
import com.iftm.api.prontuarioplus.utils.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService service;

    @GetMapping(produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
    public List<MedicoVO> findAll(){
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
    public MedicoVO findById(@PathVariable Long id) throws Exception{
        return service.findById(id);
    }

    @PostMapping(consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
            produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    public MedicoVO save(@RequestBody MedicoVO medicoVO) throws Exception {
        return service.save(medicoVO);
    }

    @PutMapping(consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
            produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    public MedicoVO update(@RequestBody MedicoVO medicoVO) throws Exception {
        return service.update(medicoVO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws Exception {
        service.delete(id);
    }
}
