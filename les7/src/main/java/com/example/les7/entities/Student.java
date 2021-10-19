package com.example.les7.entities;

import com.example.les7.repr.StudentRepr;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 24, nullable = false)
    private String name;

    @Column(name = "age")
    private Integer age;

    public Student() {
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Student(StudentRepr student) {
        if(student.getId() != null) {
            this.id = student.getId();
        }
        this.name = student.getName();
        this.age = student.getAge();
    }
}
