package hw3.a3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ThesisGradingTest {

    private ThesisGrading thesisGrading;

    @BeforeEach
    public void setUp() {
        thesisGrading = new ThesisGrading();
    }

    @Test
    public void testCalculateFinalGrade_TC1() throws NoSuchGradeException, ThirdExaminerNeededException {
        double result = thesisGrading.calculcateFinalGrade(1.0, 2.0, 0.0);
        assertEquals(1.5, result);
    }

    @Test
    public void testCalculateFinalGrade_TC2() {
        assertThrows(ThirdExaminerNeededException.class, () -> {
            thesisGrading.calculcateFinalGrade(1.0, 3.0, 0.0);
        });
    }

    @Test
    public void testCalculateFinalGrade_TC3() throws NoSuchGradeException, ThirdExaminerNeededException {
        double result = thesisGrading.calculcateFinalGrade(1.0, 3.0, 2.0);
        assertEquals(1.5, result);
    }

    @Test
    public void testCalculateFinalGrade_TC4() throws NoSuchGradeException, ThirdExaminerNeededException {
        double result = thesisGrading.calculcateFinalGrade(1.0, 3.0, 5.0);
        assertEquals(2.0, result);
    }

    @Test
    public void testCalculateFinalGrade_TC5() throws NoSuchGradeException, ThirdExaminerNeededException {
        double result = thesisGrading.calculcateFinalGrade(1.0, 5.0, 3.0);
        assertEquals(2.0, result);
    }

    // Additional tests for invalid grades
    @Test
    public void testInvalidGrade1() {
        assertThrows(NoSuchGradeException.class, () -> {
            thesisGrading.calculcateFinalGrade(6.0, 2.0, 0.0);
        });
    }

    @Test
    public void testInvalidGrade2() {
        assertThrows(NoSuchGradeException.class, () -> {
            thesisGrading.calculcateFinalGrade(1.0, 6.0, 0.0);
        });
    }

    @Test
    public void testInvalidGrade3() {
        assertThrows(NoSuchGradeException.class, () -> {
            thesisGrading.calculcateFinalGrade(1.0, 2.0, 6.0);
        });
    }
}
