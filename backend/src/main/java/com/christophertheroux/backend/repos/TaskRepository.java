package com.christophertheroux.backend.repos;

import com.christophertheroux.backend.data.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Transactional
    public long deleteByName(String name);
}
