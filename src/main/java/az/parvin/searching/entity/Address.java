package az.parvin.searching.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String country;
    private String city;
    private String addressLine;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
