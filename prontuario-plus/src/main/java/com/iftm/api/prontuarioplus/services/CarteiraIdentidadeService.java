package com.iftm.api.prontuarioplus.services;

import com.iftm.api.prontuarioplus.controllers.CarteiraIdentidadeController;
import com.iftm.api.prontuarioplus.exceptions.RequiredObjectIsNullException;
import com.iftm.api.prontuarioplus.exceptions.ResourceNotFoundException;
import com.iftm.api.prontuarioplus.mapper.DozerMapper;
import com.iftm.api.prontuarioplus.models.CarteiraIdentidade;
import com.iftm.api.prontuarioplus.repositories.CarteiraIdentidadeRepository;
import com.iftm.api.prontuarioplus.data.vo.CarteiraIdentidadeVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class CarteiraIdentidadeService {

    @Autowired
    private CarteiraIdentidadeRepository repository;

    public List<CarteiraIdentidadeVO> findAll(){
        List<CarteiraIdentidade> list = repository.findAll();
        List<CarteiraIdentidadeVO> listVO = DozerMapper.parseListObject(list, CarteiraIdentidadeVO.class);
        listVO.stream().forEach(x -> {
            try {
                x.add(linkTo(methodOn(CarteiraIdentidadeController.class).findById(x.getId())).withSelfRel());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        return listVO;
    }

    public CarteiraIdentidadeVO findById(Long id) throws Exception{
        CarteiraIdentidade entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrada"));
        CarteiraIdentidadeVO dbVO = DozerMapper.parseObject(entity, CarteiraIdentidadeVO.class);
        dbVO.add(linkTo(methodOn(CarteiraIdentidadeController.class).findById(id)).withSelfRel());
        return dbVO;
    }

    public CarteiraIdentidadeVO save(CarteiraIdentidadeVO carteiraIdentidadeVO) throws Exception {
        if(carteiraIdentidadeVO == null) throw new RequiredObjectIsNullException("Objeto está nulo");
        CarteiraIdentidade entity = DozerMapper.parseObject(carteiraIdentidadeVO, CarteiraIdentidade.class);
        entity = repository.save(entity);
        carteiraIdentidadeVO = DozerMapper.parseObject(entity, CarteiraIdentidadeVO.class);
        carteiraIdentidadeVO.add(linkTo(methodOn(CarteiraIdentidadeController.class).findById(carteiraIdentidadeVO.getId())).withSelfRel());
        return carteiraIdentidadeVO;
    }

    public CarteiraIdentidadeVO update(CarteiraIdentidadeVO carteiraIdentidadeVO) throws Exception {
        if(carteiraIdentidadeVO == null) throw new RequiredObjectIsNullException("Objeto está nulo");
        repository.findById(carteiraIdentidadeVO.getId()).orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrada"));

        CarteiraIdentidade entity = DozerMapper.parseObject(carteiraIdentidadeVO, CarteiraIdentidade.class);
        entity = repository.save(entity);
        carteiraIdentidadeVO = DozerMapper.parseObject(entity, CarteiraIdentidadeVO.class);

        carteiraIdentidadeVO.add(linkTo(methodOn(CarteiraIdentidadeController.class).findById(carteiraIdentidadeVO.getId())).withSelfRel());
        return carteiraIdentidadeVO;
    }

    public void delete(Long id) throws Exception {
        CarteiraIdentidade entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrada"));
        repository.delete(entity);
    }
}
