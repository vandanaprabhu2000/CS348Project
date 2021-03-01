package com.cs348.crud.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
/*@RunWith(JUnit4.class)
public class StudentServiceTest {
    private StudentRepository mockStudentrepository;
    private StudentService studentService;
    @Before
    public void setUp(){
        studentService = new StudentService();
        mockStudentrepository = mock(StudentRepository.class);
        studentService.setStudentRepository(mockStudentrepository);
    }
    @Test
    public void addtoStudents() {
        Student student = new Student(1, "Kayla", "University of Wisconsin Madison", 4.3);
        Mockito.when(mockStudentrepository.save(student)).thenReturn(anyInt());
        studentService.addtoStudents(student);
        Mockito.verify(mockStudentrepository, times(1)).save(student);
    }
    @Test
    public void getStudents() {
        List<Student> students = Arrays.asList(new Student(1, "Kayla",
                "University of Wisconsin Madison", 4.3));
        Mockito.when(mockStudentrepository.findAll()).thenReturn(students);
        List<Student> studentList = studentService.getStudents();
        assertEquals(students, studentList);
    }
    @Test
    public void getStudentById() {
        Student student = new Student(1, "Kayla",
                "University of Wisconsin Madison", 4.3);
        Optional<Student> optionalStudent = Optional.of(student);
        Mockito.when(mockStudentrepository.findById(1)).thenReturn(optionalStudent);
        Optional<Student> optional = studentService.getStudentById(1);
        assertEquals(optionalStudent, optional);
    }
    @Test
    public void deleteStudent() {
        when(mockStudentrepository.deleteById(1)).thenReturn(anyInt());
        studentService.deleteStudent(1);
        verify(mockStudentrepository).deleteById(1);
    }
    @Test
    public void testDeleteStudent() {
        Student student = new Student(1, "Kayla",
                "University of Wisconsin Madison", 4.3);
        when(mockStudentrepository.deleteById(1)).thenReturn(anyInt());
        studentService.deleteStudent(student);
        verify(mockStudentrepository).deleteById(student.getId());
    }
}*/