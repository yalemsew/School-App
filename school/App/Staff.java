package school.App;

import java.util.ArrayList;
import java.util.HashSet;

public class Staff extends Person {
    private double salary;
    private ArrayList<Course> courseList;
    Staff(String name,String phoneNo,int age,double salary){
        super(name,phoneNo,age);
        this.salary=salary;
    }
    public void addCourse(Course course){
        courseList.add(course);
    }
    public HashSet<Course> getCourseList() {
        return null;
    }
    public double getSalary() {
        return salary;
    }
}
