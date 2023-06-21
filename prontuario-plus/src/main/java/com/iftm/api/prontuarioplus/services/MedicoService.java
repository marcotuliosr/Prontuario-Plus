package com.iftm.api.prontuarioplus.services;

import com.iftm.api.prontuarioplus.mapper.DozerMapper;
import com.iftm.api.prontuarioplus.models.Medico;
import com.iftm.api.prontuarioplus.repositories.MedicoRepository;
import com.iftm.api.prontuarioplus.vo.MedicoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository repository;

    public List<MedicoVO> findAll() {
        return DozerMapper.parseListObject(repository.findAll(), MedicoVO.class);
    }

    public MedicoVO findById(Long id) {
        return DozerMapper.parseObject(repository.findById(id).orElse(null), MedicoVO.class);
    }

    public MedicoVO save(MedicoVO medicoVO) {
        if (verifyMedico(medicoVO)) {
            Medico medico = repository.save(DozerMapper.parseObject(medicoVO, Medico.class));
            return DozerMapper.parseObject(medico, MedicoVO.class);
        }
        return null;
    }

    public MedicoVO update(MedicoVO medicoVO) {
        Medico dbMedico = repository.findById(medicoVO.getId()).orElse(null);
        if (dbMedico != null && verifyMedico(medicoVO)) {
            Medico medico = repository.save(DozerMapper.parseObject(medicoVO, Medico.class));
            return DozerMapper.parseObject(medico, MedicoVO.class);
        }
        return null;
    }

    public String delete(Long id) {
        Medico dbMedico = repository.findById(id).orElse(null);
        if (dbMedico != null) {
            repository.deleteById(id);
            return "Medico with id " + id + " has been deleted!";
        }
        return "ID " + id + " not found!";
    }

    private boolean verifyMedico(MedicoVO medicoVO) {
        // Implemente a lógica de validação da MedicoVO conforme sua necessidade
        // Certifique-se de que os campos obrigatórios sejam preenchidos corretamente
        return true;
    }
}
