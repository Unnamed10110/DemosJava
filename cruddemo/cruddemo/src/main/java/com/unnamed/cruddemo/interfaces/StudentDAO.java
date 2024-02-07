package com.unnamed.cruddemo.interfaces;

import com.unnamed.cruddemo.DTOs.StudentIdApellidoDTO;
import com.unnamed.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    Student findById(Integer id);

    List<StudentIdApellidoDTO> getAllStudents();
    List<Student> findByLastName(String lastName);

    Student updateStudentName(Integer id, String newName);
    int updateAllNames(String nameVar);

    void updateWholeStudent(Student student, int id);


    void deleteStudent(int id);

    int deleteMultipleStudents();

}
