package human.resource.application;

import Employee.Account.Employee;

import java.util.*;

public class Position implements Cloneable{
    private ArrayList<Position> inferior =new ArrayList<>();
    private Position superior;

    private String title;
    private String description;
    private Employees employee;

    public Position getSuperior() {
        return superior;
    }
    Position(String title, String description, Employees employees){
        this.title=title;
        this.description=description;
        this.employee=employees;
    }
    public void addInferiors(Position pos){
        inferior.add(pos);
        pos.superior=this;
    }

    //check if the current object is a manager
    public boolean isManager(){
        return "Manager".equals(title);
    }
    public void printDownLine(){
        System.out.println("Position: " + this.title);
        System.out.println(this.employee.print());
        Queue<Position> seenPosition=new LinkedList<>();
        seenPosition.addAll(inferior);
        while(!seenPosition.isEmpty()){
            int size=seenPosition.size();
            while(size>0){
                Position temp=seenPosition.poll();
                if(temp!=null) {
                    print(temp);
                    seenPosition.addAll(temp.inferior);
                }
                size--;
            }

        }

    }
    public void print(Position position){
        StringBuilder detain=new StringBuilder();
        detain.append("Position : "+position.title).append("\n").append("Description: "+position.description)
                .append("Its occupied by : \n").append(position.employee.print());
        System.out.println(detain);
    }

    public StringBuilder print(){
        StringBuilder result=new StringBuilder();
        result.append("Title: ").append(title).append("\n")
                .append("Description: ").append(description).append("\n");

            result.append(employee.print()).append("\n");

        return result;
    }

    public double getSalary(){
       return employee.getSalary();
    }

    //    public boolean equals(Object ob){
//        if(this==ob)return true;
//        if(ob==null||ob.getClass()!=this.getClass())return false;
//        Position pos = (Position) ob;
//        return
//    }
    public String toString(){
        return "Title:\t"+title+"\n"+
                "Description:\t"+description;


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Objects.equals(title, position.title) && Objects.equals(description, position.description) && Objects.equals(employee, position.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, employee);
    }

    @Override
    public Position clone() throws CloneNotSupportedException {
        Position copy = (Position) super.clone();
        copy.employee = employee.clone();
        return copy;
    }

}
