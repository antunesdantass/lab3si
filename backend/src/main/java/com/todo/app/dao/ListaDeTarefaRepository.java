package com.todo.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.todo.app.pojo.ListaDeTarefa;

/**
 * Created by antunessilva on 07/02/17.
 */

public interface ListaDeTarefaRepository extends JpaRepository<ListaDeTarefa, Long> {

}
