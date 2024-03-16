package lib;
import java.util.ArrayList;
import java.util.UUID;

public class Course {
    public UUID courseID; // Unique identifier, similar to "uuid"
    public String courseCode; // Similar to "subject" in the new format
    public String courseNumber; // Similar to "number" in the new format
    public String fullName; // Course name, similar to "name" in the new format
    public ArrayList<String> courseAttributes; // Attributes, potentially similar to "semesters_offered" or additional attributes
    public String description; // Course description, merged from "courseDescription" array into a single String
    public int creditHours; // Number of credit hours, changed from int to double to accommodate partial credits if necessary
    public boolean isTransfer; // Retained from original
    private ArrayList<String> semestersOffered; // New, indicating which semesters the course is offered in
    public Grade grade;


    /**
     * Constructor of a course by taking in course code, number, description and how many credit hours it is
     * @param courseCode Letters for the class ex. CSCE
     * @param courseNumber Number for the class ex. 247
     * @param courseDescription Describes what the class accomplishes
     * @param creditHours number of credit hours the course it
     */
    public Course(UUID courseID, String courseCode, String courseNumber, String fullName, ArrayList<String> courseAttributes, String description, int creditHours, boolean isTransfer) {
        this.courseID = courseID;
        this.courseCode = courseCode;
        this.courseNumber = courseNumber;
        this.fullName = fullName;
        this.courseAttributes = courseAttributes;
        this.description = description;
        this.creditHours = creditHours;
        this.isTransfer = isTransfer;
        this.semestersOffered = new ArrayList<>();
    }

    public Course(String courseCode2, String courseNumber2, String courseDescription, int creditHours2) {
        //TODO Auto-generated constructor stub
    }

    /***
     * Checks if the course passed in is AIU
     * @param course course to check if it is AIU
     * @return true if AIU, false if not
     */
    public boolean isAIU(Course course) {
        return (course.courseAttributes.contains("AIU"));
        
    }
    /***
     * Checks if the course passed in is SCI
     * @param course course to check if it is SCI
     * @return true if SCI, false if not
     */
    public boolean isSCI(Course course) {
        return (course.courseAttributes.contains("SCI"));
    }
    /***
     * Checks if the course passed in is GFL
     * @param course course to check if it is GFL
     * @return true if GFL, false if not
     */
    public boolean isGFL(Course course) {
        return (course.courseAttributes.contains("GFL"));
    }
    /***
     * Checks if the course passed in is GHS
     * @param course course to check if it is GHS
     * @return true if GHS, false if not
     */
    public boolean isGHS(Course course) {
        return (course.getCourseAttributes().get(0).contains("GHS"));
    }
    /***
     * Checks if the course passed in is GSS
     * @param course course to check if it is GSS
     * @return true if GSS, false if not
     */
    public boolean isGSS(Course course) {
        return (course.getCourseAttributes().get(0).contains("GSS"));    }
    /***
     * Checks if the course passed in is CMS
     * @param course course to check if it is CMS
     * @return true if CMS, false if not
     */
    public boolean isCMS(Course course) {
        return (course.getCourseAttributes().get(0).contains("CMS"));    }
    /***
     * Checks if the course passed in is INF
     * @param course course to check if it is INF
     * @return true if INF, false if not
     */
    public boolean isINF(Course course) {
        return (course.getCourseAttributes().get(0).contains("INF"));    }
    /***
     * Checks if the course passed in is a founding document course
     * @param course course to check if it is a founding document course
     * @return true if a founding document course, false if not
     */
    public boolean isFoundingDoc(Course course) {
        return (course.getCourseAttributes().get(0).contains("Founding_Doc"));    }
    /***
     * Checks if the course passed in is Liberal Arts
     * @param course course to check if it is Liberal Arts
     * @return true if Liberal Arts, false if not
     */
    public boolean isLiberalArts(Course course) {
        return (course.getCourseAttributes().get(0).contains("Liberal_Arts"));    }
    /***
     * Checks if the course passed has a pre req
     * @param course course to check if has a pre req
     * @return the courses that are the pre req of the course passed in 
     */
    public Course getPrereq(Course course) {
        return null;
    }
    public ArrayList<String> getCourseAttributes() {
            return this.courseAttributes;
    }
    /**
     * combines class code, number and description
     * @return String of full name of course
     */
    public String getFullName () {
        return this.fullName;
    }
    /**
     * Returns the grade
     * @return grade for course
     */
    public Grade getGrade() {
        return this.grade;
    }
    /**
     * returns the amount of credit hours a course is
     * @return number of credit hours a course is
     */
    public int getCreditHours() {
        return this.creditHours;
    }
    class Prerequisite {
        private int choices;
        private ArrayList<UUID> courseOptions;
        private String minGrade;
    
        public Prerequisite(int choices, ArrayList<UUID> courseOptions, String minGrade) {
            this.choices = choices;
            this.courseOptions = courseOptions;
            this.minGrade = minGrade;
        }
    
        // Example getters
        public int getChoices() { return choices; }
        public ArrayList<UUID> getCourseOptions() { return courseOptions; }
        public String getMinGrade() { return minGrade; }
    }
    public Object getCourseID() {
        return this.courseID;
    }

    public Object getCourseCode() {
        return this.courseCode;
    }

    public Object getCourseNumber() {
        return this.courseNumber;
    }

    public Object getDescription() {
        return this.description;
    }
    
}
