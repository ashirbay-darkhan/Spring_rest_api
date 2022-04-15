package com.example.spring.api.model;

import com.example.spring.api.entity.TodoEntity;

public class Todo {
    private Long id;
    private String title;
    private Boolean complited;

    public static Todo toModel(TodoEntity entity) {
        Todo model = new Todo();
        model.setComplited(entity.getComplited());
        model.setTitle(entity.getTitle());
        model.setId(entity.getId());
        return model;
    }

    public Todo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getComplited() {
        return complited;
    }

    public void setComplited(Boolean complited) {
        this.complited = complited;
    }
}
