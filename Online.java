
package project1;

import java.time.LocalTime;

public class Online extends Course {
    
    public Online(String courseName, int crn, int section, String courseNumber, int creditHours, String classType, String instructor) {
        super(courseName, crn, section, courseNumber, creditHours, classType, instructor);
    }

    @Override
    public boolean conflictsWith(Course n) {
        return false;
    }
    
    @Override
    public String toString() {
        return ("#" + super.crn + ": " + super.courseNumber + "-" + super.section + " (" + super.courseName + "), " + super.instructor + ", " + super.classType);
    }

  
    @Override
    public LocalTime getStartTime() {
        return null;
    }

    @Override
    public LocalTime getEndTime() {
        return null;
    }
    
}

    


