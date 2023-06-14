package com.example.asn2.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.asn2.models.Student;
import com.example.asn2.models.StudentRepository;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class StudentController {
    @Autowired
    private StudentRepository studentRepo;

    // READ
    @GetMapping("/students/view")
    public String getAllStudents(Model model) {
        if (studentRepo.findAll() != null) {
            List<Student> students = studentRepo.findAll();
            model.addAttribute("stu", students);
        }
        else {
            List<Student> students = new ArrayList<>();
            model.addAttribute("stu", students);
        }

        return "students/showAll";
    }

    // Display graphics
    @GetMapping("/students/display")
    public String getAllStudentsDisplay(Model model) {
        if (studentRepo.findAll() != null) {
            List<Student> students = studentRepo.findAll();
            model.addAttribute("stu", students);
        }
        else {
            List<Student> students = new ArrayList<>();
            model.addAttribute("stu", students);
        }

        return "students/displayStudents";
    }

    // CREATE
    @PostMapping("/students/add")
    public String addStudent(@RequestParam Map<String, String> newStudent, HttpServletResponse response) {
        // Receives form data from adding page as parameter newStudent, and extracts info
        String newName = newStudent.get("nameForm");
        int newWeight = Integer.parseInt(newStudent.get("weightForm"));
        int newHeight = Integer.parseInt(newStudent.get("heightForm"));
        String newHair = newStudent.get("hairForm");
        double newGpa = Double.parseDouble(newStudent.get("gpaForm"));
        studentRepo.save(new Student(newName, newWeight, newHeight, newHair, newGpa));
        response.setStatus(201);

        return "students/addedStudent";
    }

    // DELETE
    @GetMapping("/students/delete/{uid}")
    public String deleteStudent(@PathVariable String uid) {
        int id = Integer.parseInt(uid);
        Student s = studentRepo.findById(id).get();
        studentRepo.delete(s);

        return "redirect:/students/view";
    }

    // Go to editing page
    @GetMapping("/students/modify/{uid}")
    public String modifyStudent(Model model, @PathVariable String uid) {
        int id = Integer.parseInt(uid);
        Student s = studentRepo.findById(id).get();
        model.addAttribute("stu", s);

        return "students/modify";
    }
    
    // Send request to database to save changes by grabbing info from forms
    @PostMapping("/students/modify/{uid}")
    public String updateStudent(@ModelAttribute("stu") Student newS, @PathVariable String uid) {
        int id = Integer.parseInt(uid);
        studentRepo.findById(id).get();
        studentRepo.save(newS);
        
        return "students/modifiedStudent"; 
    }
}
