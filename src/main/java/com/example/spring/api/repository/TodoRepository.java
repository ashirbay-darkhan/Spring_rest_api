package com.example.spring.api.repository;

import com.example.spring.api.entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<TodoEntity, Long> {
}
