package com.iftm.api.prontuarioplus.controllers;

import com.iftm.api.prontuarioplus.data.vo.CarteiraIdentidadeVO;
import com.iftm.api.prontuarioplus.services.CarteiraIdentidadeService;
import com.iftm.api.prontuarioplus.utils.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/CarteiraIdentidade")
public class CarteiraIdentidadeController {

    @Autowired
    private CarteiraIdentidadeService service;

    @GetMapping(produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
    public List<CarteiraIdentidadeVO> findAll(){
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
    public CarteiraIdentidadeVO findById(@PathVariable Long id) throws Exception{
        return service.findById(id);
    }

    @PostMapping(consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
            produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    public CarteiraIdentidadeVO save(@RequestBody CarteiraIdentidadeVO carteiraIdentidadeVO) throws Exception {
        return service.save(carteiraIdentidadeVO);
    }

    @PutMapping(consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
            produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    public CarteiraIdentidadeVO update(@RequestBody CarteiraIdentidadeVO carteiraIdentidadeVO) throws Exception {
        return service.update(carteiraIdentidadeVO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws Exception {
        service.delete(id);
    }
    
}
