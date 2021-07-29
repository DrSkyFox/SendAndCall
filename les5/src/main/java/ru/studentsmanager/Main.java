package ru.studentsmanager;

import org.hibernate.cfg.Configuration;
import ru.studentsmanager.persists.Student;
import ru.studentsmanager.repository.StudentRepository;

import javax.persistence.EntityManagerFactory;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();


        StudentRepository repository = new StudentRepository(entityManagerFactory);

        for (int i = 0; i < 10; i++) {
            repository.saveOrUpdate(new Student("Student" + i));
        }

        List<Student> students = repository.findAll();
        System.out.println("Size: " +  students.size());

        for (Student student: students
             ) {
            System.out.println(student);
        }

        Student student = repository.findById(2);
        System.out.println(student);

        System.out.println("Set to Player");
        student.setName("Player");
        repository.saveOrUpdate(student);

        System.out.println(repository.findById(2));

        repository.delete(1);


        System.out.println(student);

    }

}
