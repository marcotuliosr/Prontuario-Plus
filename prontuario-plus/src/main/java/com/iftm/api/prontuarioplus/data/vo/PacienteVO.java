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

public class PacienteVO extends RepresentationModel<PacienteVO> implements Serializable {
    private Long id;
    private String nome;
    private String endereco;
    private String dataNascimento;
    private String historicoMedico;
}
