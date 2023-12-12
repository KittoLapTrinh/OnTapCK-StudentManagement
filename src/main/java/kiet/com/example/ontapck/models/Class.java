package kiet.com.example.ontapck.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "class")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String faculty;

    public Class(String name, String faculty) {
        this.name = name;
        this.faculty = faculty;
    }
}