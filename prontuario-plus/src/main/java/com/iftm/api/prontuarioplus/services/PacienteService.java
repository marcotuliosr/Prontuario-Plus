package com.iftm.api.prontuarioplus.services;

import com.iftm.api.prontuarioplus.controllers.PacienteController;
import com.iftm.api.prontuarioplus.data.vo.PacienteVO;
import com.iftm.api.prontuarioplus.exceptions.RequiredObjectIsNullException;
import com.iftm.api.prontuarioplus.exceptions.ResourceNotFoundException;
import com.iftm.api.prontuarioplus.mapper.DozerMapper;
import com.iftm.api.prontuarioplus.models.Paciente;
import com.iftm.api.prontuarioplus.models.Paciente;
import com.iftm.api.prontuarioplus.repositories.MedicoRepository;
import com.iftm.api.prontuarioplus.repositories.PacienteRepository;
import com.iftm.api.prontuarioplus.data.vo.PacienteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    public List<PacienteVO> findAll(){
        List<Paciente> list = repository.findAll();
        List<PacienteVO> listVO = DozerMapper.parseListObject(list, PacienteVO.class);
        listVO.stream().forEach(x -> {
            try {
                x.add(linkTo(methodOn(PacienteController.class).findById(x.getId())).withSelfRel());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        return listVO;
    }

    public PacienteVO findById(Long id) throws Exception{
        Paciente entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrada"));
        PacienteVO dbVO = DozerMapper.parseObject(entity, PacienteVO.class);
        dbVO.add(linkTo(methodOn(PacienteController.class).findById(id)).withSelfRel());
        return dbVO;
    }

    public PacienteVO save(PacienteVO carteiraIdentidadeVO) throws Exception {
        if(carteiraIdentidadeVO == null) throw new RequiredObjectIsNullException("Objeto está nulo");
        Paciente entity = DozerMapper.parseObject(carteiraIdentidadeVO, Paciente.class);
        entity = repository.save(entity);
        carteiraIdentidadeVO = DozerMapper.parseObject(entity, PacienteVO.class);
        carteiraIdentidadeVO.add(linkTo(methodOn(PacienteController.class).findById(carteiraIdentidadeVO.getId())).withSelfRel());
        return carteiraIdentidadeVO;
    }

    public PacienteVO update(PacienteVO carteiraIdentidadeVO) throws Exception {
        if(carteiraIdentidadeVO == null) throw new RequiredObjectIsNullException("Objeto está nulo");
        repository.findById(carteiraIdentidadeVO.getId()).orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrada"));

        Paciente entity = DozerMapper.parseObject(carteiraIdentidadeVO, Paciente.class);
        entity = repository.save(entity);
        carteiraIdentidadeVO = DozerMapper.parseObject(entity, PacienteVO.class);

        carteiraIdentidadeVO.add(linkTo(methodOn(PacienteController.class).findById(carteiraIdentidadeVO.getId())).withSelfRel());
        return carteiraIdentidadeVO;
    }

    public void delete(Long id) throws Exception {
        Paciente entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrada"));
        repository.delete(entity);
    }
}
