package kiet.com.example.ontapck.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "student")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private double gpa;
    private LocalDate dob;
    private String phone;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class aClass;

    public Student(String name, double gpa, LocalDate dob, String phone, Class aClass) {
        this.name = name;
        this.gpa = gpa;
        this.dob = dob;
        this.phone = phone;
        this.aClass = aClass;
    }
}