package kiet.com.example.ontapck.services;

import kiet.com.example.ontapck.models.Student;
import kiet.com.example.ontapck.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public void createOrUpdate(Student s){
        studentRepository.save(s);
    }

    public void delete(long id){
        studentRepository.deleteById(id);
    }

    public Student findOne(long id){
        return studentRepository.findById(id).get();
    }

    public List<Student> getAll(){
        return studentRepository.findAll();
    }
}
