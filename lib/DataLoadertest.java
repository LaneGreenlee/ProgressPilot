package lib;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataLoadertest {
	private UserList users = UserList.getInstance();
	private ArrayList<User> userList = new ArrayList<User>();
	private ArrayList<Student> students = new ArrayList<Student>();
	private ArrayList<Advisor> advisors = new ArrayList<Advisor>();

	@BeforeEach
	public void setup() {
		userList.clear();
		students = DataLoader.getAllStudents("json/test_json/student_test.json");
		advisors = DataLoader.getAllAdvisors("json/test_json/advisor_test.json");
	}
	
	@AfterEach
	public void tearDown() {
		students.clear();
		advisors.clear();
		UserList.getInstance().getAllUsers().clear();
	}
	
	
	@Test
	void testGetStudentsSize() {
		assertEquals(1, students.size());
	}

	@Test
	void testGetUserFirstUserName() {
		assertEquals("Brax", students.get(0).getUserName());
	}
	
	@Test
	void testgetUserName() {
		assertEquals("Brax", students.get(0).getUserName());
	}

	@Test
	void testgetPassword() {
		assertEquals("West", students.get(0).getPassword());
	}

	@Test
	void testgetUscID() {
		assertEquals("P123290", students.get(0).getUSCID());
	}

	@Test
	void testgetuser_UUID() {
		assertEquals("b3d392ff-ccd5-46af-92d5-d2663369c13d", students.get(0).getID());
	}
	@Test
	void testgetuserGradYear() {
		assertEquals("2026", students.get(0).getGradYear());
	}

	@Test
	void testgetMajor() {
		assertEquals("Computer_Science", students.get(0).getMajorName());
	}

	@Test
	void testGetScholarship() {
		assertEquals("Life, Palmetto Fellows", students.get(0).getScholarship());
	}

	@Test
	void getGpa() {
		assertEquals(3.6, students.get(0).getGPA());
	}

	@Test
	void testGetFailedCourses() {
		assertEquals("b3d392ff-ccd5-46af-92d5-d2663369c13d", students.get(0).getFailedCourses().get(0).getCourseID());
	}

	@Test
	void testGetCurrentCourses() {
		assertEquals(new ArrayList<Course>(), students.get(0).getCurrentCourses());
	}

	@Test
	void testGetCompletedCourses() {
		assertEquals(new HashMap<Course, Grade>(), students.get(0).getCompletedCourses());
	}

	// Admin

	@Test
	void testGetAdminSize() {
		assertEquals(1, advisors.size());
	}
	@Test
	void testGetAdminUserName() {
		assertEquals("JSmith", advisors.get(0).getUserName());
	}

	@Test
	void testGetAdminPassword() {
		assertEquals("koala", advisors.get(0).getPassword());
	}

	@Test
	void testGetAdminFirstName() {
		assertEquals("Joanne", advisors.get(0).getFirstName());
	}

	@Test
	void testGetAdminLastName() {
		assertEquals("Smith", advisors.get(0).getLastName());
	}

	@Test
	void testGetAdminUSCID() {
		assertEquals("W83567892", advisors.get(0).getUSCID());
	}

	@Test
	void testGetAdminUUID() {
		assertEquals("22a71808-5493-4e9e-abf4-905c37a0642b", advisors.get(0).getID());
	}

	
}


