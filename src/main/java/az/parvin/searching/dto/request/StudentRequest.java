package az.parvin.searching.dto.request;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class StudentRequest {
    private String name;
    private String surname;
    private String pinCode;
    private Double gpa;
    private LocalDate birthdate;
    private BigDecimal scholarship;
}
