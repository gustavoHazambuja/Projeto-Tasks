package com.example.ProjetoTasks.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    

}
