package com.iftm.api.prontuarioplus.vo;


import java.io.Serializable;
import java.util.Objects;

public class PacienteVO implements Serializable {

    private Long id;
    private String nome;
    private String endereco;
    private String dataNascimento;
    private String historicoMedico;

    public PacienteVO() {
    }

    public PacienteVO(String nome, String endereco, String dataNascimento, String historicoMedico) {
        this.nome = nome;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.historicoMedico = historicoMedico;
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

    public String getHistoricoMedico() {
        return historicoMedico;
    }

    public void setHistoricoMedico(String historicoMedico) {
        this.historicoMedico = historicoMedico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PacienteVO medico)) return false;
        return Objects.equals(id, medico.id) && Objects.equals(getNome(), medico.getNome()) && Objects.equals(getEndereco(), medico.getEndereco()) && Objects.equals(getDataNascimento(), medico.getDataNascimento()) && Objects.equals(getHistoricoMedico(), medico.getHistoricoMedico());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getNome(), getEndereco(), getDataNascimento(), getHistoricoMedico());
    }

    @Override
    public String toString() {
        return "Medico{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", historicoMedico='" + historicoMedico + '\'' +
                '}';
    }
}
