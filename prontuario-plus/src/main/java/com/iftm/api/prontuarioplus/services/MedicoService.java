package com.iftm.api.prontuarioplus.services;

import com.iftm.api.prontuarioplus.controllers.MedicoController;
import com.iftm.api.prontuarioplus.data.vo.MedicoVO;
import com.iftm.api.prontuarioplus.exceptions.RequiredObjectIsNullException;
import com.iftm.api.prontuarioplus.exceptions.ResourceNotFoundException;
import com.iftm.api.prontuarioplus.mapper.DozerMapper;
import com.iftm.api.prontuarioplus.models.Medico;
import com.iftm.api.prontuarioplus.models.Medico;
import com.iftm.api.prontuarioplus.repositories.ConsultaRepository;
import com.iftm.api.prontuarioplus.repositories.MedicoRepository;
import com.iftm.api.prontuarioplus.data.vo.MedicoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository repository;

    public List<MedicoVO> findAll(){
        List<Medico> list = repository.findAll();
        List<MedicoVO> listVO = DozerMapper.parseListObject(list, MedicoVO.class);
        listVO.stream().forEach(x -> {
            try {
                x.add(linkTo(methodOn(MedicoController.class).findById(x.getId())).withSelfRel());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        return listVO;
    }

    public MedicoVO findById(Long id) throws Exception{
        Medico entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrada"));
        MedicoVO dbVO = DozerMapper.parseObject(entity, MedicoVO.class);
        dbVO.add(linkTo(methodOn(MedicoController.class).findById(id)).withSelfRel());
        return dbVO;
    }

    public MedicoVO save(MedicoVO carteiraIdentidadeVO) throws Exception {
        if(carteiraIdentidadeVO == null) throw new RequiredObjectIsNullException("Objeto está nulo");
        Medico entity = DozerMapper.parseObject(carteiraIdentidadeVO, Medico.class);
        entity = repository.save(entity);
        carteiraIdentidadeVO = DozerMapper.parseObject(entity, MedicoVO.class);
        carteiraIdentidadeVO.add(linkTo(methodOn(MedicoController.class).findById(carteiraIdentidadeVO.getId())).withSelfRel());
        return carteiraIdentidadeVO;
    }

    public MedicoVO update(MedicoVO carteiraIdentidadeVO) throws Exception {
        if(carteiraIdentidadeVO == null) throw new RequiredObjectIsNullException("Objeto está nulo");
        repository.findById(carteiraIdentidadeVO.getId()).orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrada"));

        Medico entity = DozerMapper.parseObject(carteiraIdentidadeVO, Medico.class);
        entity = repository.save(entity);
        carteiraIdentidadeVO = DozerMapper.parseObject(entity, MedicoVO.class);

        carteiraIdentidadeVO.add(linkTo(methodOn(MedicoController.class).findById(carteiraIdentidadeVO.getId())).withSelfRel());
        return carteiraIdentidadeVO;
    }

    public void delete(Long id) throws Exception {
        Medico entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrada"));
        repository.delete(entity);
    }
}
