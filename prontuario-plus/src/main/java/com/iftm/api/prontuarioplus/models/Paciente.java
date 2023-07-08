package com.iftm.api.prontuarioplus.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "paciente_table")
public class Paciente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pacienteid")
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "endereco", nullable = false)
    private String endereco;

    @Column(name = "dataNascimento", nullable = false)
    private String dataNascimento;

    @Column(name = "historico_medico", nullable = false)
    private String historicoMedico;

    //PACIENTE TEM UMA LISTA DE CARTEIRA DE IDENTIDADE
    @OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CarteiraIdentidade> carteiraIdentidadeList = new ArrayList<>();
}
