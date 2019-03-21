
package project1;


import java.time.LocalTime;

public abstract class Course {
    
    final String courseName;
    final int crn;
    final int section;
    final String courseNumber;
    private final int creditHours;
    final String classType;
    final String instructor;
    
    public abstract boolean conflictsWith(Course n);
    public abstract LocalTime getStartTime();
    public abstract LocalTime getEndTime();

    public Course(String courseName, int crn, int section, String courseNumber, int creditHours, String classType, String instructor) {
        this.courseName = courseName;
        this.crn = crn;
        this.section = section;
        this.courseNumber = courseNumber;
        this.creditHours = creditHours;
        this.classType = classType;
        this.instructor = instructor;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCrn() {
        return crn;
    }

    public int getSection() {
        return section;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public String getClassType() {
        return classType;
    }

    public String getInstructor() {
        return instructor;
    }

}
    

