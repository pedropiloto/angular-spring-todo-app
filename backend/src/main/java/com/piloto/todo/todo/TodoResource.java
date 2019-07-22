package com.piloto.todo.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*")
@RestController
public class TodoResource {
    @Autowired
    private TodoHardcodedService todoHardcodedService;

    @GetMapping("/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username) {
        return todoHardcodedService.findAll();
    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username, @PathVariable long id) {
        return todoHardcodedService.findById(id);
    }

    @PostMapping("/users/{username}/todos")
    public ResponseEntity<Todo> addTodo(@PathVariable String username, @RequestBody Todo todo) {
        System.out.println("cenas: " + todo);
        Todo todoCreated = todoHardcodedService.save(todo);
        return new ResponseEntity<Todo>(todoCreated,HttpStatus.OK);
    }

    @PutMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id, @RequestBody Todo todo) {
        Todo todoUpdated = todoHardcodedService.save(todo);
        return new ResponseEntity<Todo>(todoUpdated,HttpStatus.OK);
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id){
        Todo todo = todoHardcodedService.delete(id);
        if(todo!=null) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }

}
