
package project1;

import java.time.LocalTime;

public class Traditional extends Course {
    private boolean conflict;

    private LocalTime startTime;
    private LocalTime endTime;
    private String meetDays;
    private String room;
    
    
    public Traditional(String courseName, int crn, int section, String courseNumber, int creditHours, String classType, String instructor,LocalTime startTime, LocalTime endTime, String meetDays, String room) {
        super(courseName, crn, section, courseNumber, creditHours, classType, instructor);
        this.startTime = startTime;
        this.endTime = endTime;
        this.meetDays = meetDays;
        this.room = room;
    }

    @Override
    public LocalTime getStartTime() {
        return startTime;
    }

    @Override
    public LocalTime getEndTime() {
        return endTime;
    }

    public String getmeetDays() {
        return meetDays;
    }

    public String getRoom() {
        return room;
    }
       @Override
    public String toString() {
        return ("#" + super.crn + ": " + super.courseNumber + "-" + super.section + " (" + super.courseName + "), " + super.instructor + ", " + super.classType + ", " + getStartTime() + " - " + getEndTime() + ", " + getmeetDays() + ", " + getRoom());
    }
 

    
    @Override
    public boolean conflictsWith(Course n) {
        
        if (n instanceof Online) {
            conflict = false;
        }
       
        
         if (this.getStartTime().isAfter(n.getStartTime()) && this.getStartTime().isBefore(n.getEndTime())) {
            conflict = true;
        }
         else if (this.getEndTime().isAfter(n.getStartTime()) && this.getEndTime().isBefore(n.getEndTime())) {
            conflict = true;
        }
        
        else if (this.getStartTime().isAfter(n.getStartTime()) && this.getStartTime().isBefore(n.getEndTime())) {
            conflict = true;
        }
        
        else if (this.getStartTime().isAfter(n.getStartTime()) && this.getEndTime().isBefore(n.getEndTime())) {
            conflict = true;
        } 
        
        else if (this.getStartTime().isBefore(n.getStartTime()) && this.getEndTime().isAfter(n.getEndTime())) {
            conflict = true;
        }
        
        else if (this.getStartTime().equals(n.getStartTime()) && this.getEndTime().equals(n.getEndTime())) {
            conflict = true;
        }
        else {
            conflict = false;
        }
        return conflict;
    }
    
 
}
