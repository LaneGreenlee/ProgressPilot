package lib;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import static org.junit.Assert.*;

public class StudentTest {
    private Student student;
    private Course testCourse;
    private UUID studentUUID;

    @Before
    public void setUp() {
        studentUUID = UUID.randomUUID();
        student = new Student(studentUUID, "jdoe", "password", "John", "Doe", "USC123", "2024",
                MajorName.Computer_Science, 3.5, Scholarship.Hope);

        testCourse = new Course(UUID.randomUUID(), "CSCE", "490", "Capstone Project", new ArrayList<>(), "Design and implementation of a software project.", 3, false);
    }

    // Test adding and retrieving current courses
    @Test
    public void testAddAndGetCurrentCourses_BaseCase() {
        student.addCurrentCourse(testCourse);
        assertFalse("Current courses should not be empty after adding a course", student.getCurrentCourses().isEmpty());
        assertTrue("Current courses should contain the added course", student.getCurrentCourses().contains(testCourse));
    }

    @Test
    public void testAddCurrentCourse_NullInput() {
        student.addCurrentCourse(null);
        assertTrue("Current courses should remain empty when adding a null course", student.getCurrentCourses().isEmpty());
    }

    // Test handling failed courses
    @Test
    public void testAddAndGetFailedCourses_BaseCase() {
        student.getFailedCourses().add(testCourse);
        assertFalse("Failed courses should not be empty after adding a course", student.getFailedCourses().isEmpty());
        assertTrue("Failed courses should contain the added course", student.getFailedCourses().contains(testCourse));
    }

    @Test
    public void testFailedCourseWarning_WithFailedCourse() {
        String warning = student.FailedCourseWarning(testCourse);
        assertNotNull("Failed course warning should not be null", warning);
        // Assuming the FailedCourseWarning method returns a meaningful message
        assertFalse("Warning message should not be empty", warning.isEmpty());
    }

    @Test
    public void testFailedCourseWarning_NullCourse() {
        String warning = student.FailedCourseWarning(null);
        assertNull("Failed course warning should be null when course is null", warning);
    }

    // Test GPA calculations and warnings
    @Test
    public void testIsFailing_WithFailingGPA() {
        assertTrue("Should return true for a failing GPA", student.isFailing(1.5));
    }

    @Test
    public void testIsFailing_WithPassingGPA() {
        assertFalse("Should return false for a passing GPA", student.isFailing(3.0));
    }

    @Test
    public void testScholarshipWarning_BaseCase() {
        String warning = student.scholarshipWarning(2.5);
        assertNotNull("Scholarship warning should not be null", warning);
        // Assuming the scholarshipWarning method returns a meaningful message based on GPA
        assertFalse("Scholarship warning message should not be empty", warning.isEmpty());
    }

    @Test
    public void testScholarshipWarning_FailingGPA() {
        student = new Student(studentUUID, "jdoe", "password", "John", "Doe", "USC123", "2024",
                MajorName.Computer_Science, 2.0, Scholarship.Palmetto_Fellows);
        String warning = student.scholarshipWarning(2.0);
        // Assuming the scholarshipWarning method should produce a warning if GPA is below scholarship requirements
        assertTrue("Scholarship warning should indicate risk of losing scholarship", warning.contains("risk"));
    }

    // Test major requirements
    @Test
    public void testMeetsRequirements_BaseCase() {
        // This would require mocking or setting up specific conditions that define "meeting requirements"
        assertTrue("Should return true if student meets all major requirements", student.meetsRequirements());
    }

    @Test
    public void testGetCoursesRemaining_BaseCase() {
        // Assuming we can set up preconditions or mock the DataLoader to provide a preset major with specific courses
        ArrayList<Course> remainingCourses = student.getCoursesRemaining();
        assertNotNull("Remaining courses list should not be null", remainingCourses);
        // Assuming the major requires at least one course not yet completed
        assertFalse("Remaining courses should not be empty if there are uncompleted major requirements", remainingCourses.isEmpty());
    }

    // Adding notes to a student
    @Test
    public void testAddNotes_ValidNote() {
        String note = "Meeting with advisor scheduled.";
        student.addNotes(note);
        assertFalse("Notes should not be empty after adding a valid note", student.getNotes().isEmpty());
        assertTrue("Notes should contain the added note", student.getNotes().contains(note));
    }

    @Test
    public void testAddNotes_NullNote() {
        student.addNotes(null);
        assertTrue("Notes should remain empty after attempting to add a null note", student.getNotes().isEmpty());
    }

    @Test
    public void testGetNotes_Empty() {
        assertTrue("Notes should initially be empty for a new student", student.getNotes().isEmpty());
    }

    @Test
    public void testGetNotes_AfterAddingNotes() {
        String note1 = "Academic probation warning.";
        String note2 = "Tutoring sessions available.";
        student.addNotes(note1);
        student.addNotes(note2);
        assertEquals("Notes should contain exactly 2 notes after adding them", 2, student.getNotes().size());
        assertTrue("Notes should include the first added note", student.getNotes().contains(note1));
        assertTrue("Notes should include the second added note", student.getNotes().contains(note2));
    }

    // Testing GPA updates
    @Test
    public void testUpdateGPA_ValidGPA() {
        double newGPA = 3.8;
        student.updateGPA(newGPA);
        assertEquals("GPA should be updated to the new valid value", newGPA, student.getGPA(), 0.0);
    }

    @Test
    public void testUpdateGPA_InvalidGPA() {
        double initialGPA = student.getGPA();
        student.updateGPA(-1.0); // Attempt to update with an invalid GPA value
        assertEquals("GPA should remain unchanged when given an invalid update value", initialGPA, student.getGPA(), 0.0);
    }
    



    // Test toString method for student information
    @Test
    public void testToString_ContainsExpectedInfo() {
        String studentInfo = student.toString();
        assertTrue("Student information should contain the username", studentInfo.contains(student.getUserName()));
        assertTrue("Student information should contain the major", studentInfo.contains(student.getMajorName().toString()));
        assertTrue("Student information should contain GPA", studentInfo.contains(String.valueOf(student.getGPA())));
        assertTrue("Student information should contain scholarship information", studentInfo.contains(student.getScholarship().toString()));
    }
}

