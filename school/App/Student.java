package school.App;

import java.util.HashSet;

public class Student extends Person {
    private double GPA;
    private final double salary=0;

    private HashSet<Course> courseList=new HashSet<>();
//    private ArrayList<Course> courseList=new ArrayList<>();
    Student(String name, String phoneNo, int age, double GPA){
        super(name,phoneNo,age);
        this.GPA=GPA;
    }
    public void addCourse(Course course){
        courseList.add(course);
    }

    public HashSet<Course> getCourseList() {
        return courseList;
    }

    public double getSalary(){
        return salary;
    }

}
