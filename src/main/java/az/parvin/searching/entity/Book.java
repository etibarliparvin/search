package az.parvin.searching.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "books")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String name;
    private Integer year;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
