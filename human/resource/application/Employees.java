package human.resource.application;

import java.util.Objects;

public class Employees implements Cloneable {
    private String employeeID;
    private String firstName;
    private String middleInitial;
    private String lastName;
    private String birthDate;
    private String SSN;
    private double salary;



    public Employees(String employeeID, String firstName, String middleInitial, String lastName, String birthDate, String SSN, double salary) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.SSN = SSN;
        this.salary = salary;
    }

    public String getFirstName(){
        return firstName;
    }

    public StringBuilder print() {
        StringBuilder result = new StringBuilder();
        result.append("Employees Detail: ").append("\n");
        result.append("EmployeeID:'").append(employeeID).append('\n').append("FirstName: ").append(firstName).append("\n")
                .append("MiddleInitial: ").append(middleInitial).append("\n").append("LastName: ").append(lastName)
                .append("\n").append("BirthDate: ").append(birthDate).append("\n").append("SSN: ").append(SSN)
                .append("\n").append("Salary: ").append(salary).append("\n");
        return result;
    }
    public double getSalary(){
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employees employees = (Employees) o;
        return Double.compare(salary, employees.salary) == 0 && Objects.equals(employeeID,
                employees.employeeID) && Objects.equals(firstName, employees.firstName)
                && Objects.equals(middleInitial, employees.middleInitial) &&
                Objects.equals(lastName, employees.lastName) && Objects.equals(birthDate,
                employees.birthDate) && Objects.equals(SSN, employees.SSN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeID, firstName, middleInitial, lastName, birthDate, SSN, salary);
    }
    public String toString(){
        return "EmployeeID:\t"+employeeID+"\n"+
                "First Name:\t"+firstName+"\n"+
                "Middle name:\t"+middleInitial+"\n"+
                "LastName:\t"+lastName+"\n";
    }
    public Employees clone() throws CloneNotSupportedException {
        return (Employees) super.clone();
    }

}
