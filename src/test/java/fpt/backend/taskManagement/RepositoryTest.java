package fpt.backend.taskManagement;

import fpt.backend.taskManagement.task.Priority;
import fpt.backend.taskManagement.task.Status;
import fpt.backend.taskManagement.task.Task;
import fpt.backend.taskManagement.task.TaskRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@Disabled
@SpringBootTest
public class RepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    @DisplayName("Test find by id api")
    void testFindTaskById(){
        Optional<Task> task = taskRepository.findById(1L);
        Assertions.assertEquals(task.isPresent(),true);
        Task foundTask = task.get();
        Assertions.assertEquals(foundTask.getName(),"Learn Java");
        Assertions.assertEquals(foundTask.getStatus(),Status.ON_PROGRESS);
        Assertions.assertEquals(foundTask.getPriority(),Priority.HIGH);
    }

}
