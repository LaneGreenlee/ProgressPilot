package lib;
import static org.junit.Assert.assertThat;
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
	private ArrayList<Course> courses = new ArrayList<Course>();

	@BeforeEach
	public void setup() {
		userList.clear();
		students = DataLoader.getAllStudents("json/test_json/student_test.json");
		advisors = DataLoader.getAllAdvisors("json/test_json/advisor_test.json");
		courses = DataLoader.getCourses("json/test_json/course_test.json");
	}
	
	@AfterEach
	public void tearDown() {
		students.clear();
		advisors.clear();
		courses.clear();
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
		assertEquals(UUID.fromString("dfd6364e-d994-4e1f-bf55-1b1fd823b0c4"), students.get(0).getID());
	}
	@Test
	void testgetuserGradYear() {
		assertEquals("2026", students.get(0).getGradYear());
	}

	@Test
	void testgetMajor() {
		assertEquals(MajorName.Computer_Science, students.get(0).getMajorName());
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
		assertEquals(UUID.fromString("b3d392ff-ccd5-46af-92d5-d2663369c13d"), students.get(0).getFailedCourses().get(0).getCourseID());
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

	//courses
	@Test
	void testCourseSize() {
		assertEquals(2, courses.size());
	}

	@Test
	void testCourseCode() {
		assertEquals("MATH", courses.get(0).getCourseCode());
	}

	@Test
	void testCourseNumber() {
		assertEquals("142", courses.get(0).getCourseNumber());
	}

	@Test
	void testCourseAttribute() {
		assertEquals("CC", courses.get(0).getCourseAttributes().get(0));
	}

	@Test
	void testCourseDescription() {
		assertEquals("Methods of integration, sequences and series, approximations.   Four classroom hours and one laboratory hour per week.", courses.get(0).getDescription());
	}

	@Test
	void testCreditHours() {
		assertEquals(4, courses.get(0).getCreditHours());
	}

	@Test
	void testIsTransfer() {
		assertFalse(courses.get(0).isTransfer);
	}

	@Test
	void testCourseUUID () {
		assertEquals(UUID.fromString("b62aa096-37bb-4708-8f96-cc7d687973e2"), courses.get(0).getCourseID());
	}
}


