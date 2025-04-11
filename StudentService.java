package com.example.student_management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(String id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }

    // Add this method for updating a student
    public Student updateStudent(String id, Student updatedStudent) {
        Optional<Student> existingStudent = studentRepository.findById(id);
        
        if (existingStudent.isPresent()) {
            Student student = existingStudent.get();
            student.setName(updatedStudent.getName());
            student.setEmail(updatedStudent.getEmail());
            student.setAge(updatedStudent.getAge());
            student.setCourse(updatedStudent.getCourse());
            
            return studentRepository.save(student);
        } else {
            throw new RuntimeException("Student not found with ID: " + id);
        }
    }
}
