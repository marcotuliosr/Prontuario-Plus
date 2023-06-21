package com.iftm.api.prontuarioplus.services;

import com.iftm.api.prontuarioplus.mapper.DozerMapper;
import com.iftm.api.prontuarioplus.models.Consulta;
import com.iftm.api.prontuarioplus.repositories.ConsultaRepository;
import com.iftm.api.prontuarioplus.vo.ConsultaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository repository;

    public List<ConsultaVO> findAll() {
        return DozerMapper.parseListObject(repository.findAll(), ConsultaVO.class);
    }

    public ConsultaVO findById(Long id) {
        return DozerMapper.parseObject(repository.findById(id).orElse(null), ConsultaVO.class);
    }

    public ConsultaVO save(ConsultaVO consultaVO) {
        if (verifyConsulta(consultaVO)) {
            Consulta consulta = repository.save(DozerMapper.parseObject(consultaVO, Consulta.class));
            return DozerMapper.parseObject(consulta, ConsultaVO.class);
        }
        return null;
    }

    public ConsultaVO update(ConsultaVO consultaVO) {
        Consulta dbConsulta = repository.findById(consultaVO.getId()).orElse(null);
        if (dbConsulta != null && verifyConsulta(consultaVO)) {
            Consulta consulta = repository.save(DozerMapper.parseObject(consultaVO, Consulta.class));
            return DozerMapper.parseObject(consulta, ConsultaVO.class);
        }
        return null;
    }

    public String delete(Long id) {
        Consulta dbConsulta = repository.findById(id).orElse(null);
        if (dbConsulta != null) {
            repository.deleteById(id);
            return "Consulta with id " + id + " has been deleted!";
        }
        return "ID " + id + " not found!";
    }

    private boolean verifyConsulta(ConsultaVO consultaVO) {
        // Implemente a lógica de validação da ConsultaVO conforme sua necessidade
        // Certifique-se de que os campos obrigatórios sejam preenchidos corretamente
        return true;
    }
}
