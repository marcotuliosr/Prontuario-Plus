package com.iftm.api.prontuarioplus.data.vo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class CarteiraIdentidadeVO extends RepresentationModel<CarteiraIdentidadeVO> implements Serializable {
    private Long id;
    private String numeroIdentidade;
    private PacienteVO paciente;
}
