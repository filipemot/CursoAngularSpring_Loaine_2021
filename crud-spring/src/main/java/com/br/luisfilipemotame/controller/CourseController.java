package com.br.luisfilipemotame.controller;
import java.util.List;

import com.br.luisfilipemotame.model.Course;
import com.br.luisfilipemotame.repository.CourseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseController {

    private final CourseRepository courseRepository;

    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public @ResponseBody List<Course> list() {
        return courseRepository.findAll();
    }

    //@RequestMapping(method = RequestMethod.POST)
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Course create(@RequestBody Course course) {
        // System.out.println(course.getName());
        return courseRepository.save(course);
        // return ResponseEntity.status(HttpStatus.CREATED)
        //     .body(courseRepository.save(course));
    }

}