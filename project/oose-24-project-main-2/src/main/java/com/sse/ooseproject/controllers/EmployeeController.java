package com.sse.ooseproject.controllers;
import com.sse.ooseproject.EmployeeRepository;
import com.sse.ooseproject.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/employees")
    public String employees(Model model,
                            @RequestParam(name = "sort_by", defaultValue = "firstName") String sortBy,
                            @RequestParam(name = "sort_asc", defaultValue = "true") boolean sortAsc) {
        // Sort the employees based on request parameters
        Sort sort = sortAsc ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        List<Employee> employees = employeeRepository.findAll(sort);

        // Add attributes to the model
        model.addAttribute("employees", employees);
        model.addAttribute("sort_by", sortBy);
        model.addAttribute("sort_asc", sortAsc);

        // Return the name of the view
        return "employees";
    }
}
