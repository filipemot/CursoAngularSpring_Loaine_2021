package com.br.luisfilipemotame.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
public class CourseDTO{

        @JsonProperty("_id") Long id;
        @NotBlank @NotNull @Length(min = 5, max = 100) String name;
        @NotNull @Length(max = 10) @Pattern(regexp = "Back-end|Front-end") String category;
        List<LessonDTO> lessons;
}