package com.example.ProjetoTasks.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ProjetoTasks.Entites.Task;
import com.example.ProjetoTasks.Repositories.TaskRepository;


@Service
public class TaskService {
    
    @Autowired
    TaskRepository taskRepository;

    @Transactional(readOnly = true)
    public List<Task> findAll(){
        return taskRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Task findById(Long id){
        return taskRepository.findById(id).get();
    }
}
