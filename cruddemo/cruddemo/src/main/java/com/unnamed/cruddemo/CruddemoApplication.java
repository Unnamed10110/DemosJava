package com.unnamed.cruddemo;

import com.unnamed.cruddemo.DTOs.StudentIdApellidoDTO;
import com.unnamed.cruddemo.entity.Student;
import com.unnamed.cruddemo.interfaces.StudentDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner->{
			//System.out.println("Hello World!!");
			//CREATE
//			createStudent(studentDAO);

			//READ 1
			//readStudent(studentDAO, 6);

			// READ Multiple
			List<StudentIdApellidoDTO> aux=studentDAO.getAllStudents();
			for (var studentItem:aux) {
				System.out.println("Student:  "+ studentItem.getId()+" - "+ studentItem.getApellido());
			}

			// READ by last name
//			var aux2=studentDAO.findByLastName("Doe");
//			for (Student studentItem:aux2) {
//				System.out.println("Student:  "+ studentItem);
//			}

			// UPDATE firstName
//			var aux3=studentDAO.updateStudentName(4,"elpanzas");
//			System.out.println("Updated student:  "+ aux3);

			// UPDATE whole object
//			Student newStudent=new Student("TestUpdate","TestUpdate","TestUpdate");
//			studentDAO.updateWholeStudent(newStudent,1);
			// UPDATE Multiple
//			var aux2=studentDAO.updateAllNames("Tester");
//			System.out.println("Number of records updated:  "+aux2);

			// DELETE ONE
//			studentDAO.deleteStudent(4);


			//DELETE Multiple
//			var aux2=studentDAO.deleteMultipleStudents();
//			System.out.println("Number of records deleted:  "+aux2);


		};
	}

	private void readStudent(StudentDAO studentDAO, Integer id) {

		// display student
		var aux=studentDAO.findById(id);
		System.out.println("Student with id "+id+" : "+ aux);
	}

	private void createStudent(StudentDAO studentDAO){
		// create the student object
		System.out.println("Creating new student object...");
		Student tempStudent=new Student("Pepe4","Pepo","pepo@gmail.com");

		//save the student object
		System.out.println("Saving student object...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id:  "+tempStudent.getId());


	}

}
