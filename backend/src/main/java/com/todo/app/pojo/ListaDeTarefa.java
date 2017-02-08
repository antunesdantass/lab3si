package com.todo.app.pojo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by antunesdantas on 04/02/17.
 */

@Entity
@Table(name = "lista_de_tarefa")
public class ListaDeTarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    @NotNull
    private String nome;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Tarefa> tarefas;

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

    public Set<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(Set<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    public void addTarefa(Tarefa tarefa) {
        if (this.tarefas == null) {
            this.tarefas =  new HashSet<Tarefa>();
        }
        this.tarefas.add(tarefa);
    }

    public void removeTarefa(Tarefa tarefa) {
        this.tarefas.remove(tarefa);
    }

    public Tarefa getTarefa(Long id) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId().equals(id)) {
                return tarefa;
            }
        }
        return null;
    }
}