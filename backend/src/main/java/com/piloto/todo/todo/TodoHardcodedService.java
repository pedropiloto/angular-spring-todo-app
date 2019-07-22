package com.piloto.todo.todo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoHardcodedService {
    private static List<Todo> todos = new ArrayList();
    private static long idCounter = 0;

    static {
        todos.add(new Todo(++idCounter, "cenas_1", "cenas_1", new Date(), false));
        todos.add(new Todo(++idCounter, "cenas_2", "cenas_2", new Date(), false));
        todos.add(new Todo(++idCounter, "cenas_3", "cenas_3", new Date(), false));
        todos.add(new Todo(++idCounter, "cenas_4", "cenas_4", new Date(), false));
    }

    public List<Todo> findAll() {
        return todos;
    }

    public Todo save(Todo todo){
        if (todo.getId() == null || todo.getId() ==-1){
            todo.setId(++idCounter);
            todos.add(todo);
        }else{
            delete(todo.getId());
                todos.add(todo);
        }
        return todo;
    }

    public Todo delete(long id){
        Todo todo = findById(id);
        if(todo==null) return null;
        todos.remove(todo);
        return todo;
    }

    public Todo findById(long id) {
      for(Todo todo : todos){
          if(todo.getId() == id){
              return todo;
          }
      }
      return null;
    }
}
