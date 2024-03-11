package com.cribteam.cribhub.repositories;

import com.cribteam.cribhub.domain.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TaskRepository extends CrudRepository<Task, Long> {

    Task findByTaskId(long userId);

}
