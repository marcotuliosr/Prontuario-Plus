package com.iftm.api.prontuarioplus.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "carteira_identidade_table")
public class CarteiraIdentidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_identidade", nullable = false)
    private String numeroIdentidade;

    // @OneToOne(optional=false)
    // @JoinColumn(name="paciente_id", unique=true, nullable=false, updatable=false)
    // private Paciente paciente;

    //CART IDENTIDADE TEM UM PACIENTE
    @ManyToOne(optional = false)
    @JoinColumn(name = "pacienteid")
    private Paciente paciente;

}
