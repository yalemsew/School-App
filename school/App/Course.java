package school.App;

import java.util.ArrayList;

public class Course {
    private String number;
    private String title;
    private int units;
    //Assume that course and faculty have one to one relationship
    Course(String number,String title,int units){
        this.number=number;
        this.title=title;
        this.units=units;
    }
    public int getUnits() {
        return units;
    }

}
