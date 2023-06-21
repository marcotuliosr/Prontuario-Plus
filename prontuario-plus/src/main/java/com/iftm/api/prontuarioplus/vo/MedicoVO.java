package com.iftm.api.prontuarioplus.vo;


import com.iftm.api.prontuarioplus.models.Consulta;
import com.iftm.api.prontuarioplus.models.Medico;
import com.iftm.api.prontuarioplus.models.Paciente;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class MedicoVO implements Serializable {

    private Long id;
    private String nome;
    private String endereco;
    private String dataNascimento;
    private String especialidade;

    public MedicoVO() {
    }

    public MedicoVO(String nome, String endereco, String dataNascimento, String especialidade) {
        this.nome = nome;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.especialidade = especialidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MedicoVO medico)) return false;
        return Objects.equals(id, medico.id) && Objects.equals(getNome(), medico.getNome()) && Objects.equals(getEndereco(), medico.getEndereco()) && Objects.equals(getDataNascimento(), medico.getDataNascimento()) && Objects.equals(getEspecialidade(), medico.getEspecialidade());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getNome(), getEndereco(), getDataNascimento(), getEspecialidade());
    }

    @Override
    public String toString() {
        return "Medico{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", especialidade='" + especialidade + '\'' +
                '}';
    }
}
