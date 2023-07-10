package com.br.luisfilipemotame.dto.mapper;

import com.br.luisfilipemotame.dto.CourseDTO;
import com.br.luisfilipemotame.dto.LessonDTO;
import com.br.luisfilipemotame.enums.Category;
import com.br.luisfilipemotame.model.Course;
import com.br.luisfilipemotame.model.Lesson;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CourseMapper {

    public CourseDTO toDTO(Course course) {
        if (course == null) {
            return null;
        }
        List<LessonDTO> lessons = course.getLessons()
                .stream()
                .map(lesson -> new LessonDTO(lesson.getId(), lesson.getName(),
                        lesson.getYoutubeUrl()))
                .collect(Collectors.toList());
        return new CourseDTO(course.getId(), course.getName(), course.getCategory().getValue(),
                lessons);
    }

    public Course toEntity(CourseDTO courseDTO) {

        if (courseDTO == null) {
            return null;
        }

        Course course = new Course();
        if (courseDTO.getId() != null) {
            course.setId(courseDTO.getId());
        }
        course.setName(courseDTO.getName());
        course.setCategory(convertCategoryValue(courseDTO.getCategory()));

        List<Lesson> lessons = courseDTO.getLessons().stream().map(lessonDTO -> {
            var lesson = new Lesson();
            lesson.setId(lessonDTO.getId());
            lesson.setName(lessonDTO.getName());
            lesson.setYoutubeUrl(lessonDTO.getYoutubeUrl());
            lesson.setCourse(course);
            return lesson;
        }).collect(Collectors.toList());
        course.setLessons(lessons);

        return course;
    }

    public Category convertCategoryValue(String value) {
        if (value == null) {
            return null;
        }

        Category category = null;
        switch (value) {
            case "Front-end": { category = Category.FRONT_END; break;}
            case "Back-end":{ category = Category.BACK_END; break;}
            default: throw new IllegalArgumentException("Categoria inválida: " + value);
        };

        return category;
    }
}