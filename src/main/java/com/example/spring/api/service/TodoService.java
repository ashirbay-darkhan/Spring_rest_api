package com.example.spring.api.service;

import com.example.spring.api.entity.TodoEntity;
import com.example.spring.api.entity.UserEntity;
import com.example.spring.api.model.Todo;
import com.example.spring.api.repository.TodoRepository;
import com.example.spring.api.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepo userRepo;

    public Todo createTodo(TodoEntity todo, Long userId) {
        UserEntity user = userRepo.findById(userId).get();
        todo.setUser(user);
        return Todo.toModel(todoRepository.save(todo));
    }

    public Todo completeTodo(Long id) {
        TodoEntity todo = todoRepository.findById(id).get();
        todo.setComplited(!todo.getComplited());
        return Todo.toModel(todoRepository.save(todo));
    }
}
