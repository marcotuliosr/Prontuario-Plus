package com.iftm.api.prontuarioplus.repositories;

import com.iftm.api.prontuarioplus.models.CarteiraIdentidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarteiraIdentidadeRepository extends JpaRepository<CarteiraIdentidade, Long> {
}
