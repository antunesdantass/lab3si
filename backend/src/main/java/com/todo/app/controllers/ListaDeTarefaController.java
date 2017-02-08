package com.todo.app.controllers;

import com.todo.app.pojo.ListaDeTarefa;
import com.todo.app.pojo.SubTarefa;
import com.todo.app.pojo.Tarefa;
import com.todo.app.services.ListaDeTarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import java.util.List;

import java.util.Collection;

/**
 * Created by antunessilva on 07/02/17.
 */

@RestController
public class ListaDeTarefaController {

    @Autowired
    private ListaDeTarefaService service;

    public ListaDeTarefaController(ListaDeTarefaService service) {
        this.service = service;
    }

    @CrossOrigin
    @RequestMapping(
            value = "/listas",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<ListaDeTarefa>> getListasDeTarefa() {
        List<ListaDeTarefa> listaDeTarefa = service.getAllListaDeTarefa();
        return new ResponseEntity<Collection<ListaDeTarefa>>(listaDeTarefa, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(
            value = "/listas/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ListaDeTarefa> getListaDeTarefa(@PathVariable("id") Long idLista) {
        ListaDeTarefa listaDeTarefa= service.getOneListaDeTarefa(idLista);
        if (listaDeTarefa == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<ListaDeTarefa>(listaDeTarefa, HttpStatus.OK);
        }
    }

    @CrossOrigin
    @RequestMapping(
            value = "/listas",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ListaDeTarefa> createListaDeTarefa(@RequestBody ListaDeTarefa novaLista) {
        return new ResponseEntity<ListaDeTarefa>(service.createListaDeTarefa(novaLista), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(
            value = "/listas/{id}",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ListaDeTarefa> addTarefaNaLista(@PathVariable("id") Long id, @RequestBody Tarefa novaTarefa) {
        ListaDeTarefa lista = service.addTarefaNaLista(id, novaTarefa);
        return new ResponseEntity<ListaDeTarefa>(lista, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(
            value = "/listas/{idLista}/{idTarefa}/",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ListaDeTarefa> addSubTarefa(@PathVariable("idLista") Long idLista,
                                                      @PathVariable("idTarefa") Long idTarefa,
                                                      @RequestBody SubTarefa subTarefa) {
        ListaDeTarefa lista = service.addSubTarefaNaLista(idLista, idTarefa, subTarefa);
        return new ResponseEntity<ListaDeTarefa>(lista, HttpStatus.OK);
    }

}
