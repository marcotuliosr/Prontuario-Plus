package com.iftm.api.prontuarioplus.vo;


import com.iftm.api.prontuarioplus.models.Paciente;

import java.io.Serializable;
import java.util.Objects;

public class CarteiraIdentidadeVO implements Serializable {

    private Long id;
    private String numeroIdentidade;
    private Paciente paciente;

    public CarteiraIdentidadeVO() {
    }

    public CarteiraIdentidadeVO(String numeroIdentidade, Paciente paciente) {
        this.numeroIdentidade = numeroIdentidade;
        this.paciente = paciente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroIdentidade() {
        return numeroIdentidade;
    }

    public void setNumeroIdentidade(String numeroIdentidade) {
        this.numeroIdentidade = numeroIdentidade;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarteiraIdentidadeVO that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getNumeroIdentidade(), that.getNumeroIdentidade()) && Objects.equals(getPaciente(), that.getPaciente());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNumeroIdentidade(), getPaciente());
    }

    @Override
    public String toString() {
        return "CarteiraIdentidadeVO{" +
                "id=" + id +
                ", numeroIdentidade='" + numeroIdentidade + '\'' +
                ", paciente=" + paciente +
                '}';
    }
}
