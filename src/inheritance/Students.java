package inheritance;

public class Students extends Peoples{

    String classes;
    int rank;

    @Override
    public void peopleInfo(){
        super.peopleInfo();
        System.out.println("Student info");
    }
}
