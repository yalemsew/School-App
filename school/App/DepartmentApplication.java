package school.App;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class DepartmentApplication {
    public static void main(String[] args) throws IOException {
        Department dept = new Department("ComputerScience");

        //  The following commented out code will help you
        //  create the objects that you need.

        // Create faculty objects
        Person frankMoore = new Faculty("Frank Moore","472-5921",43,10000);
        Person samHoward = new Faculty("Sam Howard","472-7222",55,9500);
        Person johnDoodle = new Faculty("John Doodle","472-6190",39,8600);

        IPerson frankMoore1 = new Faculty("Frank Moore","472-5921",43,10000);

        //test 9 default and static method in IPerson interface
        frankMoore1.myDefault();
        IPerson.myStatic();







        dept.addPerson (frankMoore);
        dept.addPerson(samHoward);
        dept.addPerson(johnDoodle);


        // Create student objects
        Person johnDoe = new Student("John Doe","472-1121",22,3.8);
        Person maryJones = new Student("Mary Jones","472-7322",32,3.80);
        Person leeJohnson = new Student("Lee Johnson","472-6009",19,3.5);


        dept.addPerson (johnDoe);
        dept.addPerson(maryJones);
        dept.addPerson(leeJohnson);


        // Create staff objects
        Person frankGore = new Staff("Frank Gore","472-3321",33,4050);
        Person adamDavis = new Staff("Adam Davis","472-7552",50,5500);
        Person davidHeck = new Staff("David Heck","472-8890",29,3600);
        dept.addPerson (frankGore);
        dept.addPerson(adamDavis);
        dept.addPerson(davidHeck);

        Person janeSmith = new StaffStudent("Jane Smith", "987-654-3210", 30, 3.5,6555);
        Person bobJohnson = new StaffStudent("Bob Johnson", "555-123-4567", 28,4.0, 5500.0);
        dept.addPerson(janeSmith);
        dept.addPerson(bobJohnson);

        Course cs201 = new Course("cs201","programming",4);
        Course cs360 = new Course("cs360","database",3);
        Course cs404 = new Course("cs404","compiler",4);
        Course cs240 = new Course("cs240","datastructure",2);
        Course cs301 = new Course("cs301","Software engg",3);
        Course cs450 = new Course("cs450","Advanced architecture",5);
        HashSet<Course> courseList = new HashSet<>();
        courseList.add(cs201);
        courseList.add(cs301);
        courseList.add(cs360);
        courseList.add(cs404);
        courseList.add(cs240);
        courseList.add(cs450);




        johnDoe.addCourse(cs201);
        johnDoe.addCourse(cs360);
        johnDoe.addCourse(cs404);
        johnDoe.addCourse(cs301);

        maryJones.addCourse(cs201);
        maryJones.addCourse(cs360);
        maryJones.addCourse(cs450);

        leeJohnson.addCourse(cs201);
        leeJohnson.addCourse(cs360);
        leeJohnson.addCourse(cs240);
        leeJohnson.addCourse(cs450);

        johnDoodle.addCourse(cs201);
        johnDoodle.addCourse(cs240);
        frankMoore.addCourse(cs450);



        HashSet<Student> filteredStudents = new HashSet<>();
        for(Object person:dept.getPersonList()){
            if(person instanceof Student){
                filteredStudents.add((Student) person);
            }
        }
        HashSet<Faculty> filteredFaculty = new HashSet<>();
        for(Object person:dept.getPersonList()) {
            if (person instanceof Faculty) {
                filteredFaculty.add((Faculty) person);
            }
        }

        AdmittedStudent enrolled=new AdmittedStudent(filteredStudents,courseList,filteredFaculty);


        double totsalary = 0;

        while(true)
        {
            putText("Enter first letter of ");
            putText("getTotalSalary, showAllMembers, unitsPerFaculty,ListOfStudentByFacultyName, or quit : ");
            int choice = getChar();
            switch(choice)
            {
                case 'g':
                    totsalary=dept.getTotalSalary();
                    putText("Total sum of all salaries is:");
                    putText(String.valueOf(totsalary)+"\n");
                    break;
                case 's':
                    System.out.println(dept.showAllMembers());
                    break;
                case 'u':
                    System.out.println(dept.unitsPerFaculty());
                    break;
                case 'l':
                    System.out.println("Enter the faculty name: ");
                    String name=getString();
                    System.out.println(enrolled.getStudentByFacultyName(name));
                    break;
                case 'q': return;
                default:
                    putText("Invalid entry\n");
            }  // end switch
        }  // end while
    }  // end main()
    // -------------------------------------------------------------
    public static void putText(String s) //writes string s to the screen
    {
        System.out.println(s);
    }
    // -------------------------------------------------------------
    public static String getString() throws IOException  //reads a string from the keyboard input
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
    // -------------------------------------------------------------
    public static char getChar() throws IOException //reads a character from the keyboard input
    {
        String s = getString();
        return s.charAt(0);
    }

    //-------------------------------------------------------------
    public static int getInt() throws IOException // reads an integers from the keyboard input
    {
        String s = getString();
        return Integer.parseInt(s);
    }
// -------------------------------------------------------------
}  // end class


