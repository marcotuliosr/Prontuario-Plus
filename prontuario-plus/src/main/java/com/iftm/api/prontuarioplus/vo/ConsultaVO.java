package com.iftm.api.prontuarioplus.vo;


import com.iftm.api.prontuarioplus.models.Consulta;
import com.iftm.api.prontuarioplus.models.Medico;
import com.iftm.api.prontuarioplus.models.Paciente;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class ConsultaVO implements Serializable {

    private Long id;
    private LocalDateTime dataHoraConsulta;
    private String areaMedica;
    private Paciente paciente;
    private Medico medico;

    public ConsultaVO() {
    }

    public ConsultaVO(LocalDateTime dataHoraConsulta, String areaMedica, Paciente paciente, Medico medico) {
        this.dataHoraConsulta = dataHoraConsulta;
        this.areaMedica = areaMedica;
        this.paciente = paciente;
        this.medico = medico;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataHoraConsulta() {
        return dataHoraConsulta;
    }

    public void setDataHoraConsulta(LocalDateTime dataHoraConsulta) {
        this.dataHoraConsulta = dataHoraConsulta;
    }

    public String getAreaMedica() {
        return areaMedica;
    }

    public void setAreaMedica(String areaMedica) {
        this.areaMedica = areaMedica;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Consulta)) return false;
        ConsultaVO consulta = (ConsultaVO) o;
        return Objects.equals(id, consulta.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "id=" + id +
                ", dataHoraConsulta=" + dataHoraConsulta +
                ", areaMedica='" + areaMedica + '\'' +
                '}';
    }
}
