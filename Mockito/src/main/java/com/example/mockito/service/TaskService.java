package com.example.mockito.service;

import org.springframework.stereotype.Service;

import com.example.mockito.model.Task;
import com.example.mockito.repository.TaskRepository;

import java.util.*;

@Service
public class TaskService {
      private  TaskRepository taskRepository;
   public TaskService(TaskRepository taskRpository ){
    	     this.taskRepository=taskRepository;
    	     
   
      }
  public Task addTask( Task task){
	   if(task.getName()==null || task.getName().isBlank()) {
		   throw new IllegalArgumentException("Task name can't be empty");
	   }
	   return taskRepository.save(task);
   }
  public List<Task> getAlltask(){
	  return taskRepository.findAll();
	  
  }
      
      
}
