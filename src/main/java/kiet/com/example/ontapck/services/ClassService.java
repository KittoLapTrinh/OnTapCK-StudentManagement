package kiet.com.example.ontapck.services;
import kiet.com.example.ontapck.models.Class;
import kiet.com.example.ontapck.repositories.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClassService {
    @Autowired
    private ClassRepository classRepository;

    public void createOrUpdate(Class c){
        classRepository.save(c);
    }

    public void delete(long id){
        classRepository.deleteById(id);
    }

    public Class findOne(long id){
        return classRepository.findById(id).get();
    }

    public List<Class> getAll(){
        return classRepository.findAll();
    }
}
