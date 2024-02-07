package com.unnamed.cruddemo.DAOs;

import com.unnamed.cruddemo.DTOs.StudentIdApellidoDTO;
import com.unnamed.cruddemo.entity.Student;
import com.unnamed.cruddemo.interfaces.StudentDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
    private final EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }


//    @Override
    public List<StudentIdApellidoDTO> getAllStudents() {
        String queryString = "select NEW com.unnamed.cruddemo.DTOs.StudentIdApellidoDTO(a.id, a.lastName) FROM Student a ORDER BY a.lastName";

        TypedQuery<StudentIdApellidoDTO> res = entityManager.createQuery(queryString, StudentIdApellidoDTO.class);
        var res2=res.getResultList();

        return res2;
    }

    @Override
    public List<Student> findByLastName(String nameVar) {
        TypedQuery<Student> query = entityManager.createQuery("from Student where lastName=:THEDATA", Student.class);

        query.setParameter("THEDATA", nameVar);
        return query.getResultList();
    }

    @Override
    @org.springframework.transaction.annotation.Transactional
    public Student updateStudentName(Integer id, String newName) {
        var student = entityManager.find(Student.class, id);
        student.setFirstName(newName);

        entityManager.merge(student);
        var updatedStudent = entityManager.find(Student.class, id);
        return updatedStudent;
    }

    @Override
    @org.springframework.transaction.annotation.Transactional
    public int updateAllNames(String nameVar) {
        int numberRowsUpdated = entityManager.createQuery("UPDATE Student SET lastName=:THEDATA WHERE id>4").setParameter("THEDATA", nameVar).executeUpdate();
        return numberRowsUpdated;
    }

    @Override
    @org.springframework.transaction.annotation.Transactional
    public void updateWholeStudent(Student student, int id) {
        Student upStudent = entityManager.find(student.getClass(), id);
        upStudent.setFirstName("updatedwhole");
        upStudent.setEmail("updatedwhole");
        upStudent.setLastName("updatedwhole");

        entityManager.merge(upStudent);


    }

    @Override
    @org.springframework.transaction.annotation.Transactional
    public void deleteStudent(int id) {
        Student student = entityManager.find(Student.class, id);

        entityManager.remove(student);
    }


    @Override
    @org.springframework.transaction.annotation.Transactional
    public int deleteMultipleStudents() {
        int numberRowsDeleted = entityManager.createQuery("DELETE FROM Student WHERE lastName='Tester'").executeUpdate();
        return numberRowsDeleted;
    }
}