package com.iftm.api.prontuarioplus.repositories;

import com.iftm.api.prontuarioplus.models.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
