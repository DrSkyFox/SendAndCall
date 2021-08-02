package com.example.les7.repr;

import com.example.les7.entities.Student;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class StudentRepr {

    private Long id;

    @NotEmpty
    private String name;

    @NotNull
    private Integer age;

    public StudentRepr() {
    }

    public StudentRepr(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public StudentRepr(Student student) {
        this.id = student.getId();
        ;
        this.name = student.getName();
        this.age = student.getAge();
    }


}
