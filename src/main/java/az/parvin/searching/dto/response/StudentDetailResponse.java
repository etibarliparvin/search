package az.parvin.searching.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
public class StudentDetailResponse {
    private Long id;
    private String name;
    private String surname;
    private String pinCode;
    private Double gpa;
    private LocalDate birthdate;
    private BigDecimal scholarship;
    List<BookResponse> books;
    List<TeacherResponse> teachers;
}
