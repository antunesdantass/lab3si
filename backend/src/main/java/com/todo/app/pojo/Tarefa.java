package com.todo.app.pojo;

/**
 * Created by antunessilva on 07/02/17.
 */
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tarefa")
public class Tarefa {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column
    @NotNull
    private String titulo;
    @Column
    private String descricao;
    @Column
    @NotNull
    private boolean feita;
    @Column
    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;
    @Column
    private String categoria;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SubTarefa> subTarefas;

    public Set<SubTarefa> getSubTarefas() {
        return subTarefas;
    }

    public void setSubTarefas(Set<SubTarefa> subTarefas) {
        this.subTarefas = subTarefas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void addSubTarefa(SubTarefa subTarefa) {
        if (subTarefas == null) {
            subTarefas = new HashSet<SubTarefa>();
        }
        subTarefas.add(subTarefa);
    }

    public void removeSubTarefa(SubTarefa subTarefa) {
        subTarefas.remove(subTarefa);
    }
}
