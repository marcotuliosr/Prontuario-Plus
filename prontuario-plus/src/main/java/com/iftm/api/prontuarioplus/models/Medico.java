package com.iftm.api.prontuarioplus.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "medico_table")
public class Medico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "endereco", nullable = false)
    private String endereco;
    @Column(name = "dataNascimento", nullable = false)
    private String dataNascimento;
    @Column(name = "especialidade", nullable = false)
    private String especialidade;

    public Medico() {
    }

    public Medico(String nome, String endereco, String dataNascimento, String especialidade) {
        this.nome = nome;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.especialidade = especialidade;
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
        if (!(o instanceof Medico medico)) return false;
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
