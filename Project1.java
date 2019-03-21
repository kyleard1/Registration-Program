
package project1;
import static java.lang.Integer.parseInt;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Project1{

    
    public static void main(String[] args) {
        
        boolean conflicts;
         final int trad = 11;
         final int onl = 7;
     


        
        
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Course> schedule = new ArrayList<>();
        ArrayList<String> data = new ArrayList<>();
        String line, input;
        
        try {
            Scanner in = new Scanner(Paths.get("project1input.csv"), "UTF-8");
            
            while ( in.hasNextLine() ) {
                
                line = in.nextLine();
                
                data = new ArrayList(Arrays.asList(line.split("\t")));  
                

                if(data.size() > trad) {
                    String courseName = data.get(0);
                    int crn = parseInt(data.get(1));
                    String courseNumber = data.get(2);
                    int section = parseInt(data.get(3));
                    int creditHours = parseInt(data.get(4));
                    LocalTime startTime = LocalTime.parse(data.get(5), DateTimeFormatter.ISO_DATE);
                    LocalTime endTime = LocalTime.parse(data.get(6), DateTimeFormatter.ISO_DATE);
                    String meetDays = data.get(7);
                    String room = data.get(8);
                    String classType = data.get(9);
                    String instructor = data.get(10);
                    
                    
                    Course c = new Traditional(courseName, crn, section, courseNumber, creditHours, classType, instructor, startTime, endTime, meetDays, room);
                    courses.add(c);
                }
                else {
                    String courseName = data.get(0);
                    int crn = parseInt(data.get(1));
                    String courseNumber = data.get(2);
                    int section = parseInt(data.get(3));
                    int courseHours = parseInt(data.get(4));
                    String classType = data.get(5);
                    String instructor = data.get(6);
                    
                    Course c = new Online(courseName, crn, section, courseNumber, courseHours, classType, instructor);
                    courses.add(c);
                }
            }
            in.close(); 
            
          
            input = "0";
                while (!"4".equals(input)){
                System.out.println("1) Search Courses.");
                System.out.println("2) Register for Course.");
                System.out.println("3) View Trial Schedule.");
                System.out.println("4) Quit.");
                System.out.print("Select your option.");
                
                Scanner userIn = new Scanner(System.in);
                input = userIn.nextLine();
                
                
                if (input.equals("1")) {
                    System.out.print("Enter course number in the format SS NNN (for example, CS 201): ");

                    String courseInput = userIn.nextLine();

                    System.out.println();

                    for (int i = 0; i < courses.size(); i++) {
                        if (courseInput.equals(courses.get(i).getCourseNumber())) {
                            System.out.println(courses.get(i).toString());
                        } 
                     }
                } // end 1

                
                
                else if (input.equals("2")) {
                    
                    
                    System.out.print("Enter CRN number: ");
                    int UserInCRN = userIn.nextInt();
                    
                    for (int i = 0; i < courses.size(); i++) {
                        
                        if (UserInCRN == courses.get(i).getCrn()) {
                            
                            if (courses.get(i) instanceof Online) {
                                schedule.add(courses.get(i));
                                System.out.println("Course added.");
                            }
                            
                            else if (schedule.size() == 0) {
                                schedule.add(courses.get(i));
                                System.out.println("Course added.");
                            }
                            
                            else {
                                 conflicts = false;
                                
                                for (int k = 0; k < schedule.size(); k++) {
                                    

                                    if (schedule.get(i).conflictsWith(courses.get(k))){
                                    System.out.println("Error: This course conflicts with your schedule.");
                                        
                                       // 
                                    }
                                
                                else{
                                
                                    schedule.add(courses.get(k));
                                    
                                    System.out.println("Course added.");
                                }
                                }
                            }                            
                        }                        
                    } //end for
                } // end 2

                else if (input.equals("3")) { 
                    for (int i = 0; i < schedule.size(); i++) {
                        System.out.println(schedule.get(i).toString());
                    }
                    
                }// end 3
                
             // end of if loop
                else if(input.equals("4")){
           System.out.println("Thanks for using the student registration system!");
                    
  
        } // end try
                }
        }
        catch (Exception e) {
            System.err.println(e.toString());
}
    }
    
}

    
    

//