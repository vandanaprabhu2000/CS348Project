/*package com.vandana.crud;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import com.vandana.crud.entities.Student;
public class StudentUnitTest {
    @Test
    public void whenCalledGetName_thenCorrect() {
        Student student = new Student(2, "Grant", "University of Iowa", 4.1);
        assertThat(student.getFirstName()).isEqualTo("Grant");
    }
    @Test
    public void whenCalledGetUniversity_thenCorrect() {
        Student student = new Student(2, "Grant", "University of Iowa", 4.1);
        assertThat(student.getUniversity()).isEqualTo("University of Iowa");
    }
    @Test
    public void whenCalledGetGpa_thenCorrect(){
        Student student = new Student(2, "Grant", "University of Iowa", 4.1);
        assertThat(student.getGpa()).isEqualTo(4.1);
    }
    @Test
    public void whenCalledSetName_thenCorrect() {
        Student student = new Student(2, "Grant", "University of Iowa", 4.1);
        student.setFirstName("Grant");
        assertThat(student.getFirstName()).isEqualTo("Grant");
    }
    @Test
    public void whenCalledSetUniversity_thenCorrect() {
        Student student = new Student(2, "Grant", "University of Iowa", 4.1);
        student.setUniversity("University of Iowa");
        assertThat(student.getUniversity()).isEqualTo("University of Iowa");
    }
    @Test
    public void whenCalledSetGpa_thenCorrect(){
        Student student = new Student(2, "Grant", "University of Iowa", 4.1);
        student.setGpa(4.1);
        assertThat(student.getGpa()).isEqualTo(4.1);
    }
    @Test
    public void whenCalledtoString_thenCorrect() {
        Student student = new Student(2, "Grant", "University of Iowa", 4.1);
        assertThat(student.toString()).isEqualTo("Student{id=2, name='Grant', university='University of Iowa', gpa=4.1}");
    }
}*/