package com.todo.app.services;

import com.todo.app.dao.ListaDeTarefaRepository;
import com.todo.app.pojo.ListaDeTarefa;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import com.todo.app.pojo.*;

/**
 * Created by antunessilva on 07/02/17.
 */

@Service
@Transactional
public class ListaDeTarefaService {

    private ListaDeTarefaRepository repository;

    public ListaDeTarefaService(ListaDeTarefaRepository repository) {
        super();
        this.repository = repository;
    }

    public List<ListaDeTarefa> getAllListaDeTarefa() {
        return repository.findAll();
    }

    public ListaDeTarefa getOneListaDeTarefa(Long id) {
        return repository.findOne(id);
    }

    public ListaDeTarefa createListaDeTarefa(ListaDeTarefa novaLista) {
        return repository.save(novaLista);
    }

    public ListaDeTarefa addTarefaNaLista(Long idLista, Tarefa novaTarefa) {
        ListaDeTarefa lista = getOneListaDeTarefa(idLista);
        lista.addTarefa(novaTarefa);
        return repository.save(lista);
    }

    public ListaDeTarefa addSubTarefaNaLista(Long idLista, Long idTarefa, SubTarefa subTarefa) {
        ListaDeTarefa lista = getOneListaDeTarefa(idLista);
        lista.getTarefa(idTarefa).addSubTarefa(subTarefa);
        return repository.save(lista);
    }

    public void deletarTodasListas() {
        repository.deleteAll();
    }

    public void deletarListaEspecifica(Long id) {
        repository.delete(id);
    }

    public ListaDeTarefa deletaTarefaDeLista(Long idLista, Long idTarefa) {
        ListaDeTarefa lista = repository.findOne(idLista);
        Tarefa tarefa = lista.getTarefa(idTarefa);
        lista.removeTarefa(tarefa);
        lista = repository.saveAndFlush(lista);
        return lista;
    }

    public Tarefa deletarSubTarefa(Long idLista, Long idTarefa, Long idSubTarefa) {
        ListaDeTarefa lista = repository.findOne(idLista);
        Tarefa tarefa = lista.removeSubTarefa(idTarefa, idSubTarefa);
        repository.saveAndFlush(lista);
        return tarefa;
    }

    public Tarefa getTarefaDaLista(Long idLista, Long idTarefa) {
        ListaDeTarefa lista = repository.findOne(idLista);
        return lista.getTarefa(idTarefa);
    }

    public void atualizarTarefaDaLista(Long idLista, Tarefa tarefa) {
        ListaDeTarefa lista = repository.findOne(idLista);
    }

}
