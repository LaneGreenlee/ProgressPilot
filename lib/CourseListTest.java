package lib;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.UUID;
import static org.junit.Assert.*;

public class CourseListTest {
    private CourseList courseList;

    @Before
    public void setUp() {
        courseList = CourseList.getInstance();
        courseList.Courses.clear(); // Ensure a fresh start for each test
    }

    @Test
    public void testCreateCourse_BaseCase() {
        // Test creating a course with valid inputs
        courseList.createCourse("CSCE", "490", "Capstone Project", 3);
        assertFalse("Course list should not be empty after adding a course", courseList.getAllCourses().isEmpty());
        Course createdCourse = courseList.getAllCourses().get(0);
        assertEquals("Course code mismatch", "CSCE", createdCourse.getCourseCode());
        assertEquals("Course number mismatch", "490", createdCourse.getCourseNumber());
        assertEquals("Course description mismatch", "Capstone Project", createdCourse.getDescription());
        assertEquals("Credit hours mismatch", 3, createdCourse.getCreditHours());
    }

    @Test
    public void testCreateCourse_NullInputs() {
        // Test creating a course with null inputs
        courseList.createCourse(null, null, null, 0);
        Course createdCourse = courseList.getAllCourses().get(0);
        assertNull("Course code should be null", createdCourse.getCourseCode());
        assertNull("Course number should be null", createdCourse.getCourseNumber());
        assertNull("Course description should be null", createdCourse.getDescription());
        assertEquals("Credit hours should be 0 for null input", 0, createdCourse.getCreditHours());
    }

    @Test
    public void testDeleteCourse_ExistingCourse() {
        // Test deleting an existing course
        String courseName = "CSCE 490";
        courseList.createCourse("CSCE", "490", "Capstone Project", 3);
        assertEquals("Course list should have 1 course before deletion", 1, courseList.getAllCourses().size());
        courseList.deleteCourse(courseName);
        assertTrue("Course list should be empty after deletion", courseList.getAllCourses().isEmpty());
    }

    @Test
    public void testDeleteCourse_NonExistingCourse() {
        // Test deleting a course that does not exist
        courseList.deleteCourse("NONEXISTENT 999");
        assertTrue("Course list should remain empty when deleting a non-existing course", courseList.getAllCourses().isEmpty());
    }

    @Test
    public void testGetCourse_ByName_Existing() {
        // Test retrieving an existing course by name
        String courseName = "CSCE 490";
        courseList.createCourse("CSCE", "490", "Capstone Project", 3);
        Course retrievedCourse = courseList.getCourse(courseName);
        assertNotNull("Should retrieve an existing course by name", retrievedCourse);
        assertEquals("Retrieved course name mismatch", courseName, retrievedCourse.getFullName());
    }

    @Test
    public void testGetCourse_ByName_NonExisting() {
        // Test retrieving a non-existing course by name
        Course retrievedCourse = courseList.getCourse("NONEXISTENT 999");
        assertNull("Should not retrieve a non-existing course by name", retrievedCourse);
    }

    @Test
    public void testGetCourse_ByUUID_Existing() {
        // Test retrieving an existing course by UUID
        Course newCourse = new Course(UUID.randomUUID(), "CSCE", "490", "Capstone Project", new ArrayList<>(), "Capstone Project", 3, false);
        courseList.Courses.add(newCourse);
        Course retrievedCourse = courseList.getCourse(newCourse.fullName);
        assertNotNull("Should retrieve an existing course by UUID", retrievedCourse);
        assertEquals("Retrieved course UUID mismatch", newCourse.getCourseID(), retrievedCourse.getCourseID());
    }

    @Test
    public void testGetCourse_ByUUID_NonExisting() {
        // Test retrieving a non-existing course by UUID
        Course retrievedCourse = courseList.getCourse(UUID.randomUUID());
        assertNull("Should not retrieve a non-existing course by UUID", retrievedCourse);
    }

    @Test
    public void testGetAllAttributes_SpecificAttribute() {
        // Test retrieving all courses with a specific attribute
        String attribute = "Capstone";
        Course courseWithAttribute = new Course(UUID.randomUUID(), "CSCE", "490", "Capstone Project", new ArrayList<>(java.util.Arrays.asList(attribute)), "Capstone Project", 3, false);
        courseList.Courses.add(courseWithAttribute);
        courseList = CourseList.getInstance();
        courseList.Courses.clear(); // Ensure the course list is empty before each test
    }

    // Test creating a course with valid inputs
    @Test
    public void testCreateCourseValid() {
        courseList.createCourse("CSCE", "490", "Capstone Project", 3);
        assertFalse("Course list should not be empty after adding a course", courseList.getAllCourses().isEmpty());
        Course course = courseList.getAllCourses().get(0);
        assertEquals("Capstone Project", course.getDescription());
    }

    // Test creating a course with null inputs
    @Test
    public void testCreateCourseWithNull() {
        courseList.createCourse(null, null, null, 0);
        Course course = courseList.getAllCourses().get(0);
        assertNull("Course code should be null", course.getCourseCode());
        assertEquals(0, course.getCreditHours());
    }

    // Test deleting an existing course
    @Test
    public void testDeleteExistingCourse() {
        courseList.createCourse("CSCE", "490", "Capstone Project", 3);
        int initialSize = courseList.getAllCourses().size();
        courseList.deleteCourse("CSCE 490");
        assertEquals("Course list size should decrease after deleting a course", initialSize - 1, courseList.getAllCourses().size());
    }

    // Test attempting to delete a non-existing course
    @Test
    public void testDeleteNonExistingCourse() {
        int initialSize = courseList.getAllCourses().size();
        courseList.deleteCourse("NONEXISTENT 999");
        assertEquals("Course list size should not change when attempting to delete a non-existing course", initialSize, courseList.getAllCourses().size());
    }

    // Test retrieving a course by its full name successfully
    @Test
    public void testGetCourseByFullNameSuccess() {
        courseList.createCourse("CSCE", "490", "Capstone Project", 3);
        Course retrievedCourse = courseList.getCourse("CSCE 490");
        assertNotNull("Should successfully retrieve the course by full name", retrievedCourse);
        assertEquals("Capstone Project", retrievedCourse.getDescription());
    }

    // Test retrieving a course by a full name that doesn't exist
    @Test
    public void testGetCourseByFullNameFailure() {
        Course retrievedCourse = courseList.getCourse("NONEXISTENT 999");
        assertNull("Should not retrieve a course with a full name that doesn't exist", retrievedCourse);
    }

    // Test retrieving a course by UUID successfully
    @Test
    public void testGetCourseByUUIDSuccess() {
        UUID uuid = UUID.randomUUID();
        Course course = new Course(uuid, "CSCE", "490", "Capstone Project", new ArrayList<>(), "Capstone", 3, false);
        courseList.Courses.add(course);

        Course retrievedCourse = courseList.getCourse(uuid);
        assertNotNull("Should successfully retrieve the course by UUID", retrievedCourse);
        assertEquals(uuid, retrievedCourse.getCourseID());
    }

    // Test retrieving a course by a UUID that doesn't exist
    @Test
    public void testGetCourseByUUIDFailure() {
        Course retrievedCourse = courseList.getCourse(UUID.randomUUID());
        assertNull("Should not retrieve a course with a UUID that doesn't exist", retrievedCourse);
    }

    // Test getting all courses that contain a specific attribute
    @Test
    public void testGetAllCoursesWithAttribute() {
        Course course1 = new Course("CSCE", "101", "Introduction to Computer Science", 3);
        course1.courseAttributes.add("GSS");
        Course course2 = new Course("MATH", "141", "Calculus I", 4);
        course2.courseAttributes.add("GSS");
        Course course3 = new Course("ENGL", "101", "Introduction to Literature", 3); // Does not have GSS attribute
        courseList.Courses.add(course1);
        courseList.Courses.add(course2);
        courseList.Courses.add(course3);

        ArrayList<Course> gssCourses = courseList.getAllAtributes("GSS");
        assertEquals("Should return only courses with the 'GSS' attribute", 2, gssCourses.size());
        assertTrue("Returned courses should include the correct courses with the 'GSS' attribute", 
                   gssCourses.contains(course1) && gssCourses.contains(course2));
    }

    // Test getting courses with an attribute that doesn't exist
    @Test
    public void testGetAllCoursesWithNonexistentAttribute() {
        ArrayList<Course> courses = courseList.getAllAtributes("NONEXISTENT");
        assertTrue("Should return an empty list for a non-existent attribute", courses.isEmpty());
    }
}

