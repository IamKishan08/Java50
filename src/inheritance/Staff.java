package inheritance;

public class Staff extends Peoples {
    double Salary ;

    public void staffs(){
        super.peopleInfo();
    }
}

class Teacher extends Staff{
     String className;

}
