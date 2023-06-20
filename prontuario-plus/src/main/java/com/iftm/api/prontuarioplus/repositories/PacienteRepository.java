package com.iftm.api.prontuarioplus.repositories;

import com.iftm.api.prontuarioplus.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
