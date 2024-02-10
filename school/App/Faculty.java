package school.App;

import java.util.*;

public class Faculty extends Person {
    private double salary;
    private HashSet<Course> courseList=new HashSet<>();
    private ArrayList<Student> studentList=new ArrayList<>();
    Faculty(String name,String phoneNo,int age,double salary){
        super(name,phoneNo,age);
        this.salary=salary;
    }
    public void addCourse(Course course){
        courseList.add(course);
    }


    public HashSet<Course> getCourseList() {
        return courseList;
    }

    public double getSalary() {
        return salary;
    }
    public int getTotalUnit(){
//        int sum=0;
        OptionalInt sum = courseList.stream()
                .mapToInt(Course::getUnits)
                .reduce(Integer::sum);
//        for(Course course:courseList){
//            sum+=course.getUnits();
//        }
        return sum.orElse(0);
    }

}
