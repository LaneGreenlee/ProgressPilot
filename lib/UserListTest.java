package lib;
import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserListTest {
	private UserList userList;

	@BeforeEach
	public void setup() {
        userList = UserList.getInstance();
	}

    @AfterEach
	public void tearDown() {
		UserList.students.clear();
		UserList.advisors.clear();
		UserList.getInstance().getAllUsers().clear();
	}

    @Test
    public void testAddUser() {
        User user = new User("Hey", "Man", "Hey", "Man", "P18098");
        UserList.addUser(user);
        assertEquals(user,UserList.getUser("Hey"));
    }

    @Test
    public void testAddStudent() {
       UUID uuid = UUID.randomUUID();
        Student student = new Student(uuid, "Hey", "Man", "Hey", "Man", "P809890", "2026", MajorName.Computer_Information_Systems, 3.9, Scholarship.Hope);
        userList.addStudent(student);
        assertEquals(student, UserList.getStudent("Hey"));
    }

    @Test
    public void testAddDuplicateStudent() {
       UUID uuid = UUID.randomUUID();
       UUID uuid2 = UUID.randomUUID();
        Student student = new Student(uuid, "Hey", "Man", "Hey", "Man", "P809890", "2026", MajorName.Computer_Information_Systems, 3.9, Scholarship.Hope);
        Student student2 = new Student(uuid2, "Hey", "Man", "Hey", "Man", "P9090", "2026", MajorName.Computer_Information_Systems, 3.9, Scholarship.Hope);
        userList.addStudent(student);
        userList.addStudent(student2);
        assertEquals(null, UserList.getStudentUSCID("P9090"));
    }

    @Test
    public void testAddAdvisor() {
        UUID uuid = UUID.randomUUID();
        Advisor advisor = new Advisor("Hey", "Man", "Hey", "Man", "P123123",uuid);
        userList.addAdvisor(advisor);
        assertEquals(advisor, UserList.getAdvisor("Hey"));
    }

    @Test
    public void testAddDuplicateAdvisor() {
       UUID uuid = UUID.randomUUID();
       UUID uuid2 = UUID.randomUUID();
        Advisor advisor1 = new Advisor("Hey", "Man", "Hey", "Man", "P809890",uuid);
        Advisor advisor2 = new Advisor("Hello", "Man", "Hey", "Man", "P9090",uuid2);
        userList.addAdvisor(advisor1);
        userList.addAdvisor(advisor2);
        assertEquals(false, UserList.advisors.contains(advisor2));
    }

    @Test
    public void testGetAllStudents() {
        UUID uuid1 = UUID.randomUUID();
        UUID uuid2 = UUID.randomUUID();
        Student student1 =  new Student(uuid1, "Hey", "Man", "Hey", "Man", "P809890", "2026", MajorName.Computer_Information_Systems, 3.9, Scholarship.Hope);
        Student student2 = new Student(uuid2, "Man", "Man", "Man", "Man", "P90809", "2026", MajorName.Computer_Information_Systems, 3.8, Scholarship.Hope);
        userList.addStudent(student1);
        userList.addStudent(student2);
        assertEquals(2, userList.getAllStudents().size());
    }

    @Test
    public void testGetAllAdvisors() {
        UUID uuid = UUID.randomUUID();
        Advisor advisor = new Advisor("Hey", "Man", "Hey", "Man", "P12312", uuid);
        userList.addAdvisor(advisor);
        assertEquals(1,userList.getAllAdvisors().size());
    }

    @Test
    public void testGetAllUser() {
        UUID uuid = UUID.randomUUID();
        Advisor advisor = new Advisor("Hey", "Man", "Hey", "Man", "P12312", uuid);
        userList.addAdvisor(advisor);
        UUID uuid2 = UUID.randomUUID();
        Student student1 =  new Student(uuid2, "Hey", "Man", "Hey", "Man", "P809890", "2026", MajorName.Computer_Information_Systems, 3.9, Scholarship.Hope);
        userList.addStudent(student1);
        assertEquals(2,userList.getAllUsers().size());
    }
}
