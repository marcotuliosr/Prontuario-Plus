package com.iftm.api.prontuarioplus.services;

import com.iftm.api.prontuarioplus.controllers.ConsultaController;
import com.iftm.api.prontuarioplus.data.vo.ConsultaVO;
import com.iftm.api.prontuarioplus.exceptions.RequiredObjectIsNullException;
import com.iftm.api.prontuarioplus.exceptions.ResourceNotFoundException;
import com.iftm.api.prontuarioplus.mapper.DozerMapper;
import com.iftm.api.prontuarioplus.models.Consulta;
import com.iftm.api.prontuarioplus.models.Consulta;
import com.iftm.api.prontuarioplus.repositories.CarteiraIdentidadeRepository;
import com.iftm.api.prontuarioplus.repositories.ConsultaRepository;
import com.iftm.api.prontuarioplus.data.vo.ConsultaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository repository;

    public List<ConsultaVO> findAll(){
        List<Consulta> list = repository.findAll();
        List<ConsultaVO> listVO = DozerMapper.parseListObject(list, ConsultaVO.class);
        listVO.stream().forEach(x -> {
            try {
                x.add(linkTo(methodOn(ConsultaController.class).findById(x.getId())).withSelfRel());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        return listVO;
    }

    public ConsultaVO findById(Long id) throws Exception{
        Consulta entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrada"));
        ConsultaVO dbVO = DozerMapper.parseObject(entity, ConsultaVO.class);
        dbVO.add(linkTo(methodOn(ConsultaController.class).findById(id)).withSelfRel());
        return dbVO;
    }

    public ConsultaVO save(ConsultaVO carteiraIdentidadeVO) throws Exception {
        if(carteiraIdentidadeVO == null) throw new RequiredObjectIsNullException("Objeto está nulo");
        Consulta entity = DozerMapper.parseObject(carteiraIdentidadeVO, Consulta.class);
        entity = repository.save(entity);
        carteiraIdentidadeVO = DozerMapper.parseObject(entity, ConsultaVO.class);
        carteiraIdentidadeVO.add(linkTo(methodOn(ConsultaController.class).findById(carteiraIdentidadeVO.getId())).withSelfRel());
        return carteiraIdentidadeVO;
    }

    public ConsultaVO update(ConsultaVO carteiraIdentidadeVO) throws Exception {
        if(carteiraIdentidadeVO == null) throw new RequiredObjectIsNullException("Objeto está nulo");
        repository.findById(carteiraIdentidadeVO.getId()).orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrada"));

        Consulta entity = DozerMapper.parseObject(carteiraIdentidadeVO, Consulta.class);
        entity = repository.save(entity);
        carteiraIdentidadeVO = DozerMapper.parseObject(entity, ConsultaVO.class);

        carteiraIdentidadeVO.add(linkTo(methodOn(ConsultaController.class).findById(carteiraIdentidadeVO.getId())).withSelfRel());
        return carteiraIdentidadeVO;
    }

    public void delete(Long id) throws Exception {
        Consulta entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrada"));
        repository.delete(entity);
    }
}
