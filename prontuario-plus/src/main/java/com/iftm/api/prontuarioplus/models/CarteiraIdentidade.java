package com.iftm.api.prontuarioplus.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "carteira_identidade_table")
public class CarteiraIdentidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_identidade", nullable = false)
    private String numeroIdentidade;

    @OneToOne(optional=false)
    @JoinColumn(name="paciente_id", unique=true, nullable=false, updatable=false)
    private Paciente paciente;

    public CarteiraIdentidade() {
    }

    // Getters e setters

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarteiraIdentidade)) return false;
        CarteiraIdentidade that = (CarteiraIdentidade) o;
        return Objects.equals(id, that.id) && Objects.equals(numeroIdentidade, that.numeroIdentidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numeroIdentidade);
    }

    @Override
    public String toString() {
        return "CarteiraIdentidade{" +
                "id=" + id +
                ", numeroIdentidade='" + numeroIdentidade + '\'' +
                '}';
    }
}
