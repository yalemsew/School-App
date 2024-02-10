package human.resource.application;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

public class Department {
    private String name;
    private String location;
    private ArrayList<Position> positionList=new ArrayList<>();
    Department(String name,String location){
        this.name=name;
        this.location=location;
    }
    public void addPosition(Position position){
        positionList.add(position);
    }
    public StringBuilder print(){
        StringBuilder result=new StringBuilder();
        result= result.append("Department: ").append(name).append("\n").append("Location: ").append(location).append("\n");
        for(int i=0;i<positionList.size();i++){
            result.append(positionList.get(i).print()).append("\n");
        }
        return result;
    }
    public double getAverageSalary(){
        return positionList.stream()
                .mapToDouble(Position::getSalary)
                .average().getAsDouble();
    }
    public double getSalary(){
        return positionList.stream()
                .mapToDouble(Position::getSalary)
                .sum();

//        double salaryPerDepartment=0;
//        for(Position pos:positionList){
//            salaryPerDepartment+=pos.getSalary();
//        }
//        return salaryPerDepartment;
    }

    public void printReportingHierarchy() {
        Position departmentHead = getDepartmentHead();
        if (departmentHead != null) {
            departmentHead.printDownLine();
        }
    }

    // TODO: ...
    private Position getDepartmentHead() {
        for (Position position : positionList) {
            if (position.isManager()) {
                boolean hasExternalSuperior = false;
                if (position.getSuperior() != null) {
                    hasExternalSuperior = positionList.contains(position.getSuperior());
                }
                if (position.getSuperior() == null || !hasExternalSuperior) {
                    return position;
                }
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if(this==o) return true;
        if(o==null||getClass()!=o.getClass()) return false;

        Department that = (Department) o;
        return Objects.equals(name, that.name)&&this.name.equals(that.name) && Objects.equals(location, that.location);
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location, positionList);
    }
}

