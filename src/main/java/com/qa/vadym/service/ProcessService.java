package com.qa.vadym.service;

import java.util.List;

public interface ProcessService {
    public List<String> ruturnTodos(String user);
    public void deleteTodos(String text);

}
