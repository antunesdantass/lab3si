package com.todo.app.pojo;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by antunesdantas on 04/02/17.
 */

@Entity
@Table(name = "sub_tarefa")
public class SubTarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    @NotNull
    private String descricao;
    @Column
    @NotNull
    private boolean feita;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isFeita() {
        return feita;
    }

    public void setFeita(boolean feita) {
        this.feita = feita;
    }

}