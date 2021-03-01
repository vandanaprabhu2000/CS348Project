/*package com.vandana.crud;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import com.vandana.crud.controllers.StudentController;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.vandana.crud.entities.Student;
import com.vandana.crud.repositories.StudentRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StudentControllerUnitTest {
    private static StudentController studentController;
    private static StudentRepository mockedStudentRepository;
    private static BindingResult mockedBindingResult;
    private static Model mockedModel;

    @BeforeClass
    public static void setUpStudentControllerInstance() {
        mockedStudentRepository = mock(StudentRepository.class);
        mockedBindingResult = mock(BindingResult.class);
        mockedModel = mock(Model.class);
        studentController = new StudentController(mockedStudentRepository);
    }
    @Test
    public void whenCalledshowSignUpForm_thenCorrect() {
        Student student = new Student(1, "Kayla", "University of Wisconsin Madison", 4.3);
        assertThat(studentController.showSignUpForm(student)).isEqualTo("add-student");
    }
    @Test
    public void whenCalledaddStudentAndValidStudent_thenCorrect() {
        Student student = new Student(1, "Kayla", "University of Wisconsin Madison", 4.3);
        when(mockedBindingResult.hasErrors()).thenReturn(false);
        assertThat(studentController.addStudent(student, mockedBindingResult, mockedModel)).isEqualTo("index");
    }
    @Test
    public void whenCalledaddStudentAndInValidStudent_thenCorrect() {
        Student student = new Student(1, "Kayla", "University of Wisconsin Madison", 4.3);
        when(mockedBindingResult.hasErrors()).thenReturn(true);
        assertThat(studentController.addStudent(student, mockedBindingResult, mockedModel)).isEqualTo("add-student");
    }
    @Test(expected = IllegalArgumentException.class)
    public void whenCalledshowUpdateForm_thenIllegalArgumentException() {
        assertThat(studentController.showUpdateForm(0, mockedModel)).isEqualTo("update-student");
    }
    @Test
    public void whenCalledshowUpdateForm_callsStudentRepositoryFindById(){
        Student student = new Student(1, "Kayla", "University of Wisconsin Madison", 4.3);
        Optional<Student> optional = Optional.of(student);
        when(mockedStudentRepository.findById(1)).thenReturn(optional);
        String status = studentController.showUpdateForm(1, mockedModel);
        assertThat(status).isEqualTo("update-student");
        verify(mockedStudentRepository, times(2)).findById(1);
    }
    @Test
    public void whenCalledupdateStudentAndValidStudent_thenCorrect() {
        Student student = new Student(1, "Kayla", "University of Wisconsin Madison", 4.3);
        when(mockedBindingResult.hasErrors()).thenReturn(false);
        assertThat(studentController.updateStudent(1, student, mockedBindingResult, mockedModel)).isEqualTo("index");
    }
    @Test
    public void whenCalledupdateStudentAndInValidStudent_thenCorrect() {
        Student student = new Student(1, "Kayla", "University of Wisconsin Madison", 4.3);
        when(mockedBindingResult.hasErrors()).thenReturn(true);

        assertThat(studentController.updateStudent(1, student, mockedBindingResult, mockedModel)).isEqualTo("update-student");
    }
    @Test(expected = IllegalArgumentException.class)
    public void whenCalleddeleteStudent_thenIllegalArgumentException() {
        when(mockedStudentRepository.findById(1)).thenThrow(new IllegalArgumentException());
        assertThat(studentController.deleteStudent(1, mockedModel)).isEqualTo("index");
    }
    @Test
    public void whenCalleddeleteStudent_returnsIndexOnSuccess(){
        Student student = new Student(1, "Kayla", "University of Wisconsin Madison", 4.3);
        Optional<Student> optional = Optional.of(student);
        when(mockedStudentRepository.findById(1)).thenReturn(optional);
        when(mockedStudentRepository.deleteById(1)).thenReturn(anyInt());
        assertThat(studentController.deleteStudent(1, mockedModel)).isEqualTo("index");
        verify(mockedStudentRepository).findById(1);
        verify(mockedStudentRepository).deleteById(1);
    }
    @Test
    public void whenCalledlistStudent_returnsIndexOnSuccess(){
        List<Student> students = Arrays.asList(new Student(1, "Kayla",
                "University of Wisconsin Madison", 4.3));
        when(mockedStudentRepository.findAll()).thenReturn(students);
        assertThat(studentController.listStudents(mockedModel)).isEqualTo("index");
        verify(mockedStudentRepository, times(2)).findAll();
    }
}*/