package lib;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

import static org.junit.Assert.*;

public class SemesterTest {
    private Semester semester;
    private Course course1;
    private Course course2;
    private Student student;

    @Before
    public void setUp() {
        course1 = new Course(UUID.randomUUID(), "CS", "101", "Intro to CS", new ArrayList<>(), "Introduction to Computer Science", 3, false);
        course2 = new Course(UUID.randomUUID(), "MATH", "101", "Calculus I", new ArrayList<>(), "Differential Calculus", 4, false);
        semester = new Semester(new ArrayList<>(Arrays.asList(course1)));

        student = new Student(UUID.randomUUID(), "johnDoe", "pass123", "John", "Doe", "123456789", 
                              "2024", MajorName.Computer_Science, 3.5, Scholarship.Hope);
    }

    @Test
    public void testAddCourse_NotAlreadyPresent() {
        semester.addCourse(course2);
        assertTrue("Semester should contain the newly added course", semester.getCurrentCourses().contains(course2));
        assertEquals("Total credit hours should be updated correctly", 7, semester.totalCreditHours);
    }

    @Test
    public void testAddCourse_AlreadyPresent() {
        int initialCreditHours = semester.totalCreditHours;
        semester.addCourse(course1);
        assertFalse("Semester should not add a duplicate course", semester.getCurrentCourses().size() > 1);
        assertEquals("Total credit hours should not change when adding a duplicate course", initialCreditHours, semester.totalCreditHours);
    }

    @Test
    public void testRemoveCourse_Existing() {
        semester.removeCourse(course1);
        assertFalse("Semester should not contain the removed course", semester.getCurrentCourses().contains(course1));
        assertEquals("Total credit hours should decrease upon course removal", 0, semester.totalCreditHours);
    }

    @Test
    public void testRemoveCourse_NonExisting() {
        semester.removeCourse(course2); // course2 is not initially in the semester
        assertTrue("Removing a non-existing course should not affect the current courses", semester.getCurrentCourses().contains(course1));
        assertEquals("Total credit hours should not change when removing a non-existing course", 3, semester.totalCreditHours);
    }


    @Test
    public void testSavePlan_ValidPlan() {
        ArrayList<Course> plan = new ArrayList<>(Arrays.asList(course1, course2));
        semester.savePlan(plan);
        assertEquals("Saved plan should match the provided plan", plan, semester.plan);
    }

    @Test
    public void testDeletePlan_AfterSaving() {
        ArrayList<Course> plan = new ArrayList<>(Arrays.asList(course1, course2));
        semester.savePlan(plan);
        semester.deletePlan();
        assertTrue("Plan should be empty after deletion", semester.plan.isEmpty());
    }

    @Test
    public void testGetCurrentCourses_BaseCase() {
        ArrayList<Course> currentCourses = semester.getCurrentCourses();
        assertNotNull("Current courses should not be null", currentCourses);
        assertTrue("Current courses should include initially added course", currentCourses.contains(course1));
    }
}
