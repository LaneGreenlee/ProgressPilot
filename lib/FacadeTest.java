package lib;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

public class FacadeTest {
    private ProgessPilotFACADE facade;
    private UserList userList;
    private UUID uuid = UUID.randomUUID();
    private Student tim = new Student(uuid, "hey", "man", "Tim", "White", "P1234", "2025", MajorName.Computer_Information_Systems, 3.1, lib.Scholarship.Palmetto_Fellows);
    private Student tom = new Student(uuid, "hEy", "mAn", "Tom", "Brady","P19080", "2026", MajorName.Computer_Information_Systems, 3.90, lib.Scholarship.Life);
    private Advisor ad = new Advisor("Advisor", "Test", "Ad", "Tes", "P90908", uuid);
    
    @Before
    public void setUp() {
        facade = new ProgessPilotFACADE();
        userList = UserList.getInstance();
        userList.addAdvisor(ad);
        userList.addStudent(tom);
        userList.addStudent(tim);
    }

    @Test
    public void capSensitiveStudentLoginTest() {
        Student studentTest = facade.studentLogin("Advisor", "Test");
        facade.studentLogin("hey", "man");
        assertNull("Invalid student login should return null", studentTest);
    }

    @Test
    public void studentLoginTest() {
        facade.studentLogin("hey", "man");
        assertEquals(facade.studentLogin("hey","man"), tim);
        //assertEquals(tim,facade.studentLogin("hey","man"));
    }
    
    @Test
    public void testInvalidStudentLogin() {
        // Attempting login with invalid credentials
        Student student = facade.studentLogin("invalidUsername", "invalidPassword");
        assertNull("Invalid student login should return null", student);
    }

    @Test
    public void testAdvisorLogin() {
        // Assuming there exists an Advisor with these credentials in the system
        Advisor adTest = facade.advisorLogin("Advisor", "Test");
        assertNotNull("Advisor login should return a valid user", ad);
        assertEquals(adTest, ad);
    }

    @Test
    public void capSensitiveAdvisorLoginTest() {
        Advisor advisor = facade.advisorLogin("AD", "TEST");
        assertNull("Invalid student login should return null", advisor);
    }    


    @Test
    public void testInvalidAdvisorLogin() {
        // Attempting login with invalid credentials
        Advisor advisor = facade.advisorLogin("invalidUsername", "invalidPassword");
        assertNull("Invalid student login should return null", advisor);
    }

    @Test
    public void testSignUp() {
        // Assuming the username doesn't already exist in the system
        User user = facade.signup("Advisor","signup", "Hey", "Man", "P32131");
        User userTest = (UserList.getUser("Advisor"));
        assertEquals(user, userTest);
    }

    @Test
    public void testNullUserNameSignUp() {
        // Assuming the username doesn't already exist in the system
        User user = facade.signup(null,"signup", "Hey", "Man", "P32131");
        User userTest = (UserList.getUser(null));
        assertEquals(user, userTest);
    }

    @Test
    public void testNullPasswordSignUp() {
        // Assuming the username doesn't already exist in the system
        User user = facade.signup("Advisor",null, "Hey", "Man", "P32131");
        User userTest = (UserList.getUser("Advisor"));
        assertEquals(user, userTest);
    }

    @Test
    public void testNullFirstNameSignUp() {
        // Assuming the username doesn't already exist in the system
        User user = facade.signup("Advisor","Test", null, "Man", "P32131");
        User userTest = (UserList.getUser("Advisor"));
        assertEquals(user, userTest);
    }

    @Test
    public void testNullLastNameSignUp() {
        // Assuming the username doesn't already exist in the system
        User user = facade.signup("Advisor","signup", "Hey", null, "P32131");
        User userTest = (UserList.getUser("Advisor"));
        assertEquals(user, userTest);
    }

    @Test
    public void testNulluscIDSignUp() {
        // Assuming the username doesn't already exist in the system
        User user = facade.signup("Advisor","signup", "Hey", "Man", null);
        User userTest = (UserList.getUser("Advisor"));
        assertEquals(user, userTest);
    }

    @Test
    public void testUserNameDuplicateAccountSignUp() {
        // Assuming the username doesn't already exist in the system
        User userDuplicate = new User ("Advisor", "Duplicate", "Test", "Sign", "P1231");
        UserList.addUser(userDuplicate);
        User user = facade.signup("Advisor","signup", "Hey", "Man", null);
        assertEquals(user, null);
    }

    @Test
    public void testLogout() {
        facade.logout();
        assertNull("Logout should return null", null);
    }

    @Test
    public void isLoggedIn() {
        facade.studentLogin("hey", "man");
        assertEquals(true, facade.isLoggedIn());
    }
}
