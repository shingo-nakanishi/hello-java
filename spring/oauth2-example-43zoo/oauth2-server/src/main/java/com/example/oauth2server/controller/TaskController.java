package com.example.oauth2server.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.oauth2server.entity.Task;
import com.example.oauth2server.service.TaskFindService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskFindService taskService;

    @GetMapping
    public List<Task> tasks() {
        return taskService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> task(@PathVariable("id") final Long id) {
        final Optional<Task> res = Optional.ofNullable(taskService.findById(id));

        return res.map(e -> new ResponseEntity<>(e, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
