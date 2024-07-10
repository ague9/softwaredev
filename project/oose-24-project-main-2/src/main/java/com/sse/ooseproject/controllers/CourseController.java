package com.sse.ooseproject.controllers;

import com.sse.ooseproject.CourseRepository;
import com.sse.ooseproject.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Sort;

import java.util.List;

@Controller
public class CourseController {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping("/courses")
    public String courses(@RequestParam(name = "sort_by", required = false, defaultValue = "title") String sortBy,
                          @RequestParam(name = "sort_asc", required = false, defaultValue = "true") boolean sortAsc,
                          Model model) {
        Sort sort = sortAsc ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        List<Course> courses = courseRepository.findAll(sort);

        model.addAttribute("courses", courses);
        model.addAttribute("sort_by", sortBy);
        model.addAttribute("sort_asc", sortAsc);

        return "courses";
    }
}

