package human.resource.application;

import java.lang.reflect.AnnotatedArrayType;
import java.util.ArrayList;

public class Company {
    private String name;
    private ArrayList<Department> departmentList=new ArrayList<>();
    Company(String name){
        this.name=name;
    }
    public void addDepartment(Department dept){
        departmentList.add(dept);
    }
    public void print(){
        System.out.println("Name:"+name);
        for(Department dept:departmentList){
            System.out.println(dept.print());
        }
    }
    public double getSalary(){
//        double totalCompanySalary=0;
        return departmentList.stream()
                .mapToDouble(Department::getSalary)
                .sum();

//        for(Department dept:departmentList){
//            totalCompanySalary+=dept.getSalary();
//        }
//        return totalCompanySalary;
    }
}
