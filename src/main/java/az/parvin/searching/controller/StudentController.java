package az.parvin.searching.controller;

import az.parvin.searching.search.student.SearchMappingFilter;
import az.parvin.searching.service.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final SearchMappingFilter filter;

    @GetMapping("/search")
    public ResponseEntity<?> search(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String surname,
            @RequestParam(required = false) String pinCode,
            @RequestParam(required = false) Double gpa,
            @RequestParam(required = false) LocalDate birthdate,
            @RequestParam(required = false) BigDecimal minScholarship,
            @RequestParam(required = false) BigDecimal maxScholarship,
            @RequestParam(required = false) String country,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String addressLine,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String authorName,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) String teacherName,
            @RequestParam(required = false) String teacherSurname,
            @RequestParam(required = false) String grade,
            @RequestParam(required = false) String gender
    ) {
        return ResponseEntity.ok(studentService.search(filter.setMapFilter(
                page, size, name, surname, pinCode, gpa, birthdate, minScholarship, maxScholarship, country,
                city, addressLine, author, authorName, year, teacherName, teacherSurname, grade, gender
        )));
    }
}
