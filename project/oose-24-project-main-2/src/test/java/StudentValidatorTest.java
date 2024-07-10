import com.sse.ooseproject.InstituteRepository;
import com.sse.ooseproject.StudentRepository;
import com.sse.ooseproject.models.Student;
import com.sse.ooseproject.models.StudentValidationException;
import com.sse.ooseproject.models.StudentValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class StudentValidatorTest {

    private StudentRepository studentRepository;
    private InstituteRepository instituteRepository;
    private StudentValidator studentValidator;

    @BeforeEach
    public void setUp() {
        studentRepository = Mockito.mock(StudentRepository.class);
        instituteRepository = Mockito.mock(InstituteRepository.class);
        studentValidator = new StudentValidator(studentRepository, instituteRepository);
    }

    @Test
    public void testValidStudent() throws StudentValidationException {
        Student student = new Student();
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setEmail("john.doe@example.com");
        student.setMatNr(123456);
        student.setStudySubject("Computer Science");

        when(studentRepository.findByMatNr(123456)).thenReturn(Optional.empty());
        when(instituteRepository.existsByStudySubject("Computer Science")).thenReturn(true);

        studentValidator.validateStudent(student);
    }

    @Test
    public void testEmptyFirstName() {
        Student student = new Student();
        student.setFirstName("");
        student.setLastName("Doe");
        student.setEmail("john.doe@example.com");
        student.setMatNr(123456);
        student.setStudySubject("Computer Science");

        when(studentRepository.findByMatNr(123456)).thenReturn(Optional.empty());
        when(instituteRepository.existsByStudySubject("Computer Science")).thenReturn(true);

        assertThrows(StudentValidationException.class, () -> studentValidator.validateStudent(student));
    }

    @Test
    public void testInvalidEmail() {
        Student student = new Student();
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setEmail("invalid-email");
        student.setMatNr(123456);
        student.setStudySubject("Computer Science");

        when(studentRepository.findByMatNr(123456)).thenReturn(Optional.empty());
        when(instituteRepository.existsByStudySubject("Computer Science")).thenReturn(true);

        assertThrows(StudentValidationException.class, () -> studentValidator.validateStudent(student));
    }

    @Test
    public void testExistingMatNr() {
        Student student = new Student();
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setEmail("john.doe@example.com");
        student.setMatNr(123456);
        student.setStudySubject("Computer Science");

        when(studentRepository.findByMatNr(123456)).thenReturn(Optional.of(student));
        when(instituteRepository.existsByStudySubject("Computer Science")).thenReturn(true);

        assertThrows(StudentValidationException.class, () -> studentValidator.validateStudent(student));
    }

    @Test
    public void testNonExistingStudySubject() {
        Student student = new Student();
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setEmail("john.doe@example.com");
        student.setMatNr(123456);
        student.setStudySubject("Unknown Subject");

        when(studentRepository.findByMatNr(123456)).thenReturn(Optional.empty());
        when(instituteRepository.existsByStudySubject("Unknown Subject")).thenReturn(false);

        assertThrows(StudentValidationException.class, () -> studentValidator.validateStudent(student));
    }
}
