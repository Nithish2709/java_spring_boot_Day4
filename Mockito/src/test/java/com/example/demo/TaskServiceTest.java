package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.mockito.model.Task;
import com.example.mockito.repository.TaskRepository;
import com.example.mockito.service.TaskService;
import java.util.*;

@SpringBootTest
class TaskServiceTest {

	@Mock
	private TaskRepository taskRepository;
@InjectMocks
private TaskService taskService;
@BeforeEach
void setUp() {
	MockitoAnnotations.openMocks(this);
}
	   void testAddTask(){
		   Task task=new Task(1,"LearnMockito");
		   when(taskRepository.save(task)).thenReturn(task);
		   Task result=taskService.addTask(task);
		   assertEquals("learn Mockito",result.getName());
		   verify(taskRepository,times(1)).save(task);
		   
		   
	   }
	   @Test
	   void testAddTaskWithEmptyName() {
		   Task task=new Task(1,"");
		   assertThrows(IllegalArgumentException.class,()->taskService.addTask(task));
		   verify(taskRepository,never()).save(any());
		   
		   
	   }
	   @Test
	   void testGetAllTask() {
		   List<Task>tasks=Arrays.asList(new Task(1,"A"), new Task(2,"B"));
		   when(taskRepository.findAll()).thenReturn(tasks);
		   List <Task> result=taskService.getAlltask();
		   assertEquals(2,result.size());
		   verify(taskRepository,times(1)).findAll();
		   
		   
		   
	   }
	   
}





	

