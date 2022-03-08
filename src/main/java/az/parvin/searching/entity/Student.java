package az.parvin.searching.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "students")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String pinCode;
    private Double gpa;
    private LocalDate birthdate;
    private BigDecimal scholarship;

    @OneToOne(mappedBy = "student")
    private Address address;

    @OneToMany(mappedBy = "student")
    private List<Book> books;

    @ManyToMany(mappedBy = "students")
    private List<Teacher> teachers;
}
