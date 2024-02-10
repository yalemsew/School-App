package school.App;

public class StaffStudent extends Student{
    private double GPA;
    private Staff staff;
    StaffStudent(String name, String phoneNo, int age, double GPA, double salary) {
        super(name, phoneNo, age,GPA);
        staff=new Staff(name,phoneNo,age,salary);
    }
    public double getSalary(){
        return staff.getSalary();
    }
}
