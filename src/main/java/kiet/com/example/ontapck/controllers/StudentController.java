package kiet.com.example.ontapck.controllers;

import kiet.com.example.ontapck.models.Student;
import kiet.com.example.ontapck.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public String getAllStudent(Model model){
        model.addAttribute("students", studentService.getAll());
        return "students";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model){
        Student s = new Student();
        model.addAttribute("student", s);
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student s){
        studentService.createOrUpdate(s);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model){
        model.addAttribute("student", studentService.findOne(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model){
        Student s = studentService.findOne(id);

        s.setId(id);
        s.setName(student.getName());
        s.setGpa(student.getGpa());
        s.setDob(student.getDob());
        s.setPhone(student.getPhone());

        studentService.createOrUpdate(s);

        return "redirect:/students";
    }

    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.delete(id);
        return "redirect:/students";
    }
}
