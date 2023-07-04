package com.iftm.api.prontuarioplus.data.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ConsultaVO extends RepresentationModel<ConsultaVO> implements Serializable {
    private Long id;
    private LocalDateTime dataHoraConsulta;
    private String areaMedica;
    private PacienteVO paciente;
    private MedicoVO medico;
}
