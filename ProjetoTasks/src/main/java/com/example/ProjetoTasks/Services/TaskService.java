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

    @Transactional
    public Task updateTask(Long id, Task t){

        Task result = taskRepository.findById(id).get();

        result.setName(t.getName());
        result.setDescription(t.getDescription());
        result.setCompleted(t.isCompleted());

        return taskRepository.save(result);
    }

    @Transactional
    public Task addTask(Task k){
        return taskRepository.save(k);
    }

    @Transactional
    public void deleteTask(Long id){

        if(!taskRepository.existsById(id)){
            throw new RuntimeException("Task not found.");
        }
        taskRepository.deleteById(id);
    }
}
