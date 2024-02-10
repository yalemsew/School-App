package school.App;

import javax.xml.stream.events.StartDocument;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class AdmittedStudent {
    private HashSet<Student> listOfStudent;
    private HashSet<Course> listOfCourse;
    private HashSet<Faculty> listOfFaculty;

    AdmittedStudent(HashSet<Student> lp,HashSet<Course> lc,HashSet<Faculty> lf){
        this.listOfCourse=lc;
        this.listOfStudent=lp;
        this.listOfFaculty=lf;
    }
    public List<Student> getStudentByFacultyName(String name){
        List<Student> studentList=new ArrayList<>();
//        Faculty targetFaculty=null;

//        for(Faculty faculty:listOfFaculty){
//            if(name.equals(faculty.getName())){
//                targetFaculty=faculty;
//                break;
//            }
//        }
        Faculty targetFaculty = listOfFaculty.stream()
                .filter(ob->ob.getName().equals(name))
                .findFirst().orElse(null);

        if(targetFaculty!=null) {
            for (Course course : targetFaculty.getCourseList()) {
                studentList = listOfStudent.stream().filter(student -> student.getCourseList().contains(course))
                        .toList();
//            for(Person student:listOfStudent){
//                if(student.getCourseList().contains(course)){
//                    studentList.add((Student) student);
//                }
//            }
//        }
            }
        }else{
            System.out.println("The faculty name is not registered");
        }
        return studentList;
    }


}
