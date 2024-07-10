package com.sse.ooseproject.controllers;

import com.sse.ooseproject.CourseRepository;
import com.sse.ooseproject.EnrollmentRepository;
import com.sse.ooseproject.StudentRepository;
import com.sse.ooseproject.models.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {

    private final StudentRepository studentRepository;
    private final StudentValidator studentValidator;
    private final EnrollmentRepository enrollmentRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository, StudentValidator studentValidator,
                             EnrollmentRepository enrollmentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.studentValidator = studentValidator;
        this.enrollmentRepository = enrollmentRepository;
        this.courseRepository = courseRepository;
    }

    @GetMapping("/student/new")
    public String newStudent(Model model) {
        List<String> studySubjects = Arrays.asList("Computer Science", "Mathematics", "Physics", "Chemistry", "Biology");

        model.addAttribute("student", new Student());
        model.addAttribute("page_type", "new");
        model.addAttribute("study_subjects", studySubjects);

        return "edit_student";
    }

    @PostMapping("/student/new")
    public String createStudent(@ModelAttribute Student student, Model model) {
        return processStudent(student, model, "new");
    }

    @GetMapping("/student/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            List<String> studySubjects = Arrays.asList("Computer Science", "Mathematics", "Physics", "Chemistry", "Biology");

            model.addAttribute("student", student);
            model.addAttribute("page_type", "edit");
            model.addAttribute("study_subjects", studySubjects);

            return "edit_student";
        } else {
            // Handle case where student with given id is not found
            return "redirect:/"; // Redirect to home page or appropriate error page
        }
    }

    @PostMapping("/student/edit/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute Student student, Model model) {
        student.setId(id); // Ensure the student object has the correct ID from the path variable
        return processStudent(student, model, "edit");
    }

    private String processStudent(Student student, Model model, String pageType) {
        List<String> studySubjects = Arrays.asList("Computer Science", "Mathematics", "Physics", "Chemistry", "Biology");

        try {
            studentValidator.validateStudent(student);
            studentRepository.save(student);

            model.addAttribute("student", new Student());
            model.addAttribute("page_type", pageType);
            model.addAttribute("study_subjects", studySubjects);
            model.addAttribute("message_type", "success");
            model.addAttribute("message", "Student successfully updated!");
        } catch (StudentValidationException e) {
            model.addAttribute("student", student);
            model.addAttribute("page_type", pageType);
            model.addAttribute("study_subjects", studySubjects);
            model.addAttribute("message_type", "error");
            model.addAttribute("message", e.getMessage());
        }

        return "edit_student";
    }

    // Endpoint to view enrollments of a student in a semester
    @GetMapping("/student/enroll")
    public String viewEnrollments(@RequestParam Long id, @RequestParam String semester, Model model) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            List<Enrollment> enrollments = enrollmentRepository.findByStudentAndSemester(student, semester);

            // Fetch courses based on study subject
            List<Course> courses = courseRepository.findByStudySubject(student.getStudySubject());

            model.addAttribute("student", student);
            model.addAttribute("enrollments", enrollments);
            model.addAttribute("semester", semester);
            model.addAttribute("courses", courses);

            return "enrollment";
        } else {
            // Handle case where student with given id is not found
            return "redirect:/"; // Redirect to home page or appropriate error page
        }
    }

    // Endpoint to create a new enrollment
    @GetMapping("/enrollment/enroll")
    public String enrollStudent(@RequestParam Long student_id, @RequestParam Long course_id,
                                @RequestParam String semester, Model model) {
        Optional<Student> optionalStudent = studentRepository.findById(student_id);
        Optional<Course> optionalCourse = courseRepository.findById(course_id);

        if (optionalStudent.isPresent() && optionalCourse.isPresent()) {
            Student student = optionalStudent.get();
            Course course = optionalCourse.get();

            Enrollment enrollment = new Enrollment(course, student, semester);
            enrollmentRepository.save(enrollment);
        }

        return viewEnrollments(student_id, semester, model);
    }

    // Endpoint to delete enrollment of a student in a course for a semester
    @GetMapping("/enrollment/delete")
    public String deleteEnrollment(@RequestParam Long student_id, @RequestParam Long course_id,
                                   @RequestParam String semester, Model model) {
        Optional<Student> optionalStudent = studentRepository.findById(student_id);
        Optional<Course> optionalCourse = courseRepository.findById(course_id);

        if (optionalStudent.isPresent() && optionalCourse.isPresent()) {
            Student student = optionalStudent.get();
            Course course = optionalCourse.get();
            enrollmentRepository.deleteByStudentAndCourseAndSemester(student, course, semester);
        }

        return viewEnrollments(student_id, semester, model);
    }
}
