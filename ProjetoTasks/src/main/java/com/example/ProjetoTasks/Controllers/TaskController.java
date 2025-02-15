package com.example.ProjetoTasks.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProjetoTasks.Entites.Task;
import com.example.ProjetoTasks.Services.TaskService;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {
    
    @Autowired
    TaskService taskService;

    @GetMapping
    public List<Task> findAll(){
        return taskService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Task findById(@PathVariable Long id){
        return taskService.findById(id);
    }

    @PutMapping(value = "/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task t){
        return taskService.updateTask(id, t);
    }

    @PostMapping
    public Task addTask(@RequestBody Task k){
        return taskService.addTask(k);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }

    @PatchMapping(value = "/{id}")
    public Task markTaskCompleted(@PathVariable Long id){
        return taskService.markTaskCompleted(id);
    }


}
