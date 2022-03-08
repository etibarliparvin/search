package az.parvin.searching.search;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class SearchFilter {

    private Integer page;
    private Integer size;
    private String name;
    private String surname;
    private String pinCode;
    private Double gpa;
    private LocalDate birthdate;
    private BigDecimal scholarship;
    private String country;
    private String city;
    private String addressLine;
    private String author;
    private String authorName;
    private Integer year;
    private String teacherName;
    private String teacherSurname;
    private String grade;
    private String gender;
}
