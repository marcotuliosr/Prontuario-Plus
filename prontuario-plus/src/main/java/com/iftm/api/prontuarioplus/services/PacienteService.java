package com.iftm.api.prontuarioplus.services;

import com.iftm.api.prontuarioplus.mapper.DozerMapper;
import com.iftm.api.prontuarioplus.models.Paciente;
import com.iftm.api.prontuarioplus.repositories.PacienteRepository;
import com.iftm.api.prontuarioplus.vo.PacienteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    public List<PacienteVO> findAll() {
        return DozerMapper.parseListObject(repository.findAll(), PacienteVO.class);
    }

    public PacienteVO findById(Long id) {
        return DozerMapper.parseObject(repository.findById(id).orElse(null), PacienteVO.class);
    }

    public PacienteVO save(PacienteVO pacienteVO) {
        if (verifyPaciente(pacienteVO)) {
            Paciente paciente = repository.save(DozerMapper.parseObject(pacienteVO, Paciente.class));
            return DozerMapper.parseObject(paciente, PacienteVO.class);
        }
        return null;
    }

    public PacienteVO update(PacienteVO pacienteVO) {
        Paciente dbPaciente = repository.findById(pacienteVO.getId()).orElse(null);
        if (dbPaciente != null && verifyPaciente(pacienteVO)) {
            Paciente paciente = repository.save(DozerMapper.parseObject(pacienteVO, Paciente.class));
            return DozerMapper.parseObject(paciente, PacienteVO.class);
        }
        return null;
    }

    public String delete(Long id) {
        Paciente dbPaciente = repository.findById(id).orElse(null);
        if (dbPaciente != null) {
            repository.deleteById(id);
            return "Paciente with id " + id + " has been deleted!";
        }
        return "ID " + id + " not found!";
    }

    private boolean verifyPaciente(PacienteVO pacienteVO) {
        // Implemente a lógica de validação da PacienteVO conforme sua necessidade
        // Certifique-se de que os campos obrigatórios sejam preenchidos corretamente
        return true;
    }
}
