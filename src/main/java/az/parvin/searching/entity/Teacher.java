package az.parvin.searching.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teachers")
@Data
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String grade;
    private String gender;

    @ManyToMany
    @JoinTable(name = "teacher_student",
            joinColumns = @JoinColumn(name = "teacher_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"))
    private List<Student> students;
}
