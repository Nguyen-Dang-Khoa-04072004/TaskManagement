package fpt.backend.taskManagement;

import fpt.backend.taskManagement.exception.TaskNotFoundException;
import fpt.backend.taskManagement.task.*;
import fpt.backend.taskManagement.task.implement.TaskServiceImpl;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test Task APIs")
public class TaskAPITests {

    private List<Task> mockTasks = new ArrayList<>();

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskServiceImpl taskService;


    private TaskAPITests(){
        // create the mock data
        mockTasks.add( new Task("Learn English", false,Priority.HIGH));
        mockTasks.add( new Task("Learn Java", true,Priority.HIGH));
    }


    @Test
    @DisplayName("Test get all task api")
    void testGetAllTasksAPI(){

        // define behavior of repository
        when(taskRepository.findAll(any(Specification.class))).thenReturn(mockTasks);

        // call the service method
        List<Task> tasks = taskService.getAllTasks(null,null,null);

        // ensure repository is called
        verify(taskRepository).findAll(any(Specification.class));

        // assert the result
        Assertions.assertEquals(tasks, mockTasks);
    }


    @Test
    @DisplayName("Test get a task success")
    void testGetTaskSuccess(){
        // define behavior of repository
        when(taskRepository.findById(1L)).thenReturn(Optional.of(mockTasks.get(0)));

        // check if task is found
        Task task = taskService.getTask(1L);
        Assertions.assertEquals(task,mockTasks.get(0));

        verify(taskRepository).findById(anyLong());
    }
    @Test
    @DisplayName("Test get task failed")
    void testGetTaskFailed(){

        when(taskRepository.findById(3L)).thenThrow(new TaskNotFoundException());

        // check if task is not found
        Assertions.assertThrows(TaskNotFoundException.class,() -> {
            taskService.getTask(3L);
        });

        verify(taskRepository).findById(anyLong());
    }
}
