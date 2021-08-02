package com.example.SpringBasics;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.StyledEditorKit;
import java.util.ArrayList;

@RestController()
@RequestMapping("/")
public class HelloController {
    ArrayList<Task> tasklist=new ArrayList<>();

    @GetMapping("/todo")
    ArrayList<Task> getAllTasks(){
        return this.getTasks();
    }

    @GetMapping("/todo/{id}")
    public Task getOneTask(@PathVariable(value = "id") int id){
        Task task=tasklist.get(id-1);
        return task;
    }

    @PostMapping("/todo")
    public ArrayList<Task> addTask(@Validated @RequestBody Task task){
        tasklist.add(task);
        return this.getTasks();
    }
    @PutMapping("/todo/{id}")
    public ArrayList<Task> updateTask(@PathVariable(value = "id") int id){
        Task task=tasklist.get(id-1);
        task.setDone(true);
        tasklist.set(id-1,task);
        return this.getTasks();
    }
    @DeleteMapping("/todo/{id}")
    public ArrayList<Task> deleteTask(@PathVariable(value = "id") int id){
        Task task=tasklist.get(id-1);
        task.setDone(false);
        tasklist.set(id-1,task);
        return this.getTasks();
    }


    ArrayList<Task> getTasks(){
        return tasklist;
    }
}
