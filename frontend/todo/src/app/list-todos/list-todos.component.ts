import { Component, OnInit } from "@angular/core";
import { TodoDataService } from "../service/data/todo-data.service";
import { Router } from "@angular/router";

export class Todo {
  constructor(
    public id: number,
    public description: string,
    public done: boolean,
    public targetDate: Date
  ) {}
}

@Component({
  selector: "app-list-todos",
  templateUrl: "./list-todos.component.html",
  styleUrls: ["./list-todos.component.css"]
})
export class ListTodosComponent implements OnInit {
  todos = [];
  message = undefined;

  constructor(private todoService: TodoDataService, private router: Router) {}

  ngOnInit() {
    this.todoService.retrieveAllTodos("cenas").subscribe(response => {
      console.log(response);
      this.todos = response;
    });
  }

  updateTodo(id) {
    this.router.navigate(["todos", id]);
  }

  deleteTodo(id) {
    console.log("deleting", id);
    this.todoService.deleteTodo("cenas", id).subscribe(response => {
      console.log("deleted", response);
      this.message = "Delete Successfull";
      this.todos = this.todos.filter(a => a.id != id);
    });
  }

  addTodo() {
    this.router.navigate(["todos", -1]);
  }
}
