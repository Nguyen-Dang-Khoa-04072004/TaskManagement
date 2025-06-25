package fpt.backend.taskManagement.task;

import ch.qos.logback.core.util.StringUtil;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class TaskSpec {
    private TaskSpec(){}
    public static Specification<Task> isCompleted(Boolean isCompleted){
        return (root, query, builder) -> {
            if (isCompleted == null) {
                return builder.conjunction();
            }
            return builder.equal(root.get("isCompleted"),isCompleted);
        };
    }

    public static Specification<Task> hasPriority(List<String> priorityList){
        return (root, query, builder) -> {
            if (priorityList == null || priorityList.isEmpty()) {
                return builder.conjunction();
            }
            return root.get("priority").in(priorityList);
        };
    }

    public static  Specification<Task> nameLike(String name){
        return (root, query, builder) -> {
            if(StringUtil.isNullOrEmpty(name)){
                return builder.conjunction();
            }
            return builder.like(builder.lower(root.get("name")),"%" + name.toLowerCase() + "%");
        };
    }
}
