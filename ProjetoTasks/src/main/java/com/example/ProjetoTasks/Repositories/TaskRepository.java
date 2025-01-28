package com.example.ProjetoTasks.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProjetoTasks.Entites.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    
}
