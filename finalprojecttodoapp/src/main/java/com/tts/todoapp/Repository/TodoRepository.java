package com.tts.todoapp.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.todoapp.Model.Todo;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long>{

}
