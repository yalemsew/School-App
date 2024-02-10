package human.resource.application;

import payroll.system.DateRange;

public class Application {
    public static void main(String[] args) throws CloneNotSupportedException {
        //Employee list
        Employees johnDoe = new Employees("E12345", "John", "M", "Doe", "1990-05-15", "123-45-6789", 60000.0);
        Employees johnDoe1 = new Employees("E12345", "John", "M", "Doe", "1990-05-15", "123-45-6789", 60000.0);

        //test 1 equal() in employee class;
//        System.out.println(johnDoe1.equals(johnDoe));

        // test7 hashcode() in employee class
//        System.out.println(johnDoe1.hashCode()==johnDoe.hashCode());



        Employees janeSmith = new Employees("E67890", "Jane", "L", "Smith", "1988-08-22", "987-65-4321", 75000.0);
        Employees robertJohnson = new Employees("E54321", "Robert", "A", "Johnson", "1995-03-10", "456-78-9012", 55000.0);

        Employees aliceBrown = new Employees("E98765", "Alice", "K", "Brown", "1993-12-05", "789-01-2345", 70000.0);
        Employees michaelDavis = new Employees("E23456", "Michael", "J", "Davis", "1987-07-18", "234-56-7890", 80000.0);
        Employees emmaMiller = new Employees("E78901", "Emma", "S", "Miller", "1998-02-28", "567-89-0123", 65000.0);
        //test 5 for toString() in employee class
//        System.out.println(aliceBrown);

        //test 13 clone() in employee
//        Employees copyOfJane = janeSmith.clone();
//        System.out.println(copyOfJane);
//        System.out.println(janeSmith);


        //list of position

        Position softwareEngineer = new Position("Software Engineer", "Developing and maintaining software applications",janeSmith);
        Position dataAnalyst = new Position("Data Analyst", "Analyzing and interpreting complex data sets",johnDoe);
        Position marketingManager = new Position("Manager", "Creating and implementing marketing strategies",robertJohnson);

        Position softwareEngineer2 = new Position("Software Engineer", "Developing and maintaining software applications",janeSmith);

        //test 5 toString() in position class
//        System.out.println(softwareEngineer2);
        //test 8 hashcode() for position class

        //test 12 clone() in position class
        Position copyOfDataAnalyst= dataAnalyst.clone();
        System.out.println(copyOfDataAnalyst);
        System.out.println(dataAnalyst);
        System.out.println(copyOfDataAnalyst.hashCode()== dataAnalyst.hashCode());

//        System.out.println(softwareEngineer2.hashCode()==softwareEngineer.hashCode());
//        System.out.println(softwareEngineer.hashCode()==dataAnalyst.hashCode());


        softwareEngineer.addInferiors(dataAnalyst);
        marketingManager.addInferiors(softwareEngineer);

//        softwareEngineer2.addInferiors(dataAnalyst);
//        marketingManager.addInferiors(softwareEngineer2);
//        System.out.println(marketingManager);

        //test2 equal() method in position class
//        System.out.println(softwareEngineer2.equals(softwareEngineer));
//        System.out.println(softwareEngineer.hashCode()==softwareEngineer2.hashCode());

        Position projectManager = new Position("Manager", "Overseeing project development and execution",aliceBrown);
        Position financialAnalyst = new Position("Financial Analyst", "Analyzing financial data and trends", michaelDavis);
        Position graphicDesigner = new Position("Graphic Designer", "Creating visual concepts and designs",emmaMiller);
        financialAnalyst.addInferiors(graphicDesigner);
        projectManager.addInferiors(financialAnalyst);


        //Department list

        Department engineeringDepartment = new Department("Engineering", "Headquarters");
        Department marketingDepartment = new Department("Marketing", "Regional Office");
        Department marketingDepartment2 = new Department("Marketing", "Regional Office");

        //test3 for department equal method
//        System.out.println(engineeringDepartment.equals(marketingDepartment));
//        System.out.println(marketingDepartment2.equals(marketingDepartment));
        //test 6 toString () in Department class
//        System.out.println(engineeringDepartment);

        engineeringDepartment.addPosition(softwareEngineer);
        engineeringDepartment.addPosition(dataAnalyst);
        engineeringDepartment.addPosition(marketingManager);

        marketingDepartment.addPosition(projectManager);
        marketingDepartment.addPosition(financialAnalyst);
        marketingDepartment.addPosition(graphicDesigner);

        //Company
        Company techCompany=new Company("WZ-Company");
        techCompany.addDepartment(engineeringDepartment);
        techCompany.addDepartment(marketingDepartment);

//        techCompany.print();
//        System.out.println("Marketing Department total salary: "+marketingDepartment.getSalary());
//        System.out.println("Tech Company total salary: "+techCompany.getSalary());
//        engineeringDepartment.printReportingHierarchy();
//        marketingDepartment.printReportingHierarchy();




    }
}
