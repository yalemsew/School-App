package school.App;

import java.util.ArrayList;

public class Department {
    private String name;
    private ArrayList personList =new ArrayList<>();

    Department(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalSalary(){
        double totalSalary=0;
        for (Object o : personList) {
            Person person = (Person) o;
            double salary = person.getSalary();
            totalSalary += salary;
        }
        return totalSalary;
    }
    public void addPerson(Person ob){
            personList.add(ob);
    }
    public StringBuilder showAllMembers(){
        StringBuilder member = new StringBuilder();
        for(Object o:personList){
            Person person=(Person) o;
            String className=person.getClass().getSimpleName();
            member.append(person.toString()).append("\n").append("Type is ").append(className).append("\n\n");
        }
        return member;

    }

    public ArrayList getPersonList() {
        return personList;
    }

    public StringBuilder unitsPerFaculty(){
        StringBuilder data=new StringBuilder();
        for(Object o:personList){
            Person person=(Person)o;
            if(person instanceof Faculty ){
                data.append(person.getName()).append(": ")
                        .append(((Faculty) person).getTotalUnit()).append("\n");
            }
        }
        return data;
    }

}
