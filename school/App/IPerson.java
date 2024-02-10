package school.App;

public interface IPerson {
    public static void myStatic(){
        System.out.println("From static method");
    }
    default void myDefault(){
        System.out.println("From default method");
    }
}
