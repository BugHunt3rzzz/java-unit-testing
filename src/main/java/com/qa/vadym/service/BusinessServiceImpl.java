package com.qa.vadym.service;

import java.util.List;

import static com.qa.vadym.Utils.Utils.collectionAsStream;
import static java.util.stream.Collectors.toList;

public class BusinessServiceImpl {
    private ProcessService processService;

    public BusinessServiceImpl(ProcessService processService) {
        this.processService = processService;
    }

    public List<String> retrieveTodosRelatedToSpring(String user) {
        List<String> strings = processService.ruturnTodos(user);

        return collectionAsStream(strings)
                .filter(string -> string.contains("Spring"))
                .collect(toList());
    }

    public void deleteTodosRelatedWithSpring(String user) {
        List<String> strings = processService.ruturnTodos(user);

        strings.forEach(todo -> {
            if (!todo.contains("Spring")) {
                processService.deleteTodos(todo);
            }
        });
    }
}
