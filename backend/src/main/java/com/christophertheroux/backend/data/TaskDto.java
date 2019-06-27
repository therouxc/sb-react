package com.christophertheroux.backend.data;

import java.util.Date;

public class TaskDto {

    private String name;
    private String description;
    private long id;
    private boolean complete;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    @Override
    public String toString() {
        return "[id=" + id + ", name=" + name + ", description=" + description + ", complete=" + complete + "]";
    }
}
