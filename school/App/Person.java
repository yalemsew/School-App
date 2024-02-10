package school.App;

import java.util.HashSet;
import java.util.List;

public abstract class Person implements IPerson {
    private String name;
    private String phoneNo;
    private int age;
    Person(String name,String phoneNo,int age){
        this.name=name ;
        this.phoneNo=phoneNo;
        this.age=age;
    }

    public abstract double getSalary();
    public abstract void addCourse(Course course);
    public abstract HashSet<Course> getCourseList();
    public String getName() {
        return name;
    }
    public String toString(){
        return "Name: "+ name+"\n"+"Phone number: "+phoneNo+"\n"+
                "Age: "+age;
    }
}
