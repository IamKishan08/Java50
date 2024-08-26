package RailwayReservation;

class Passenger {

    static  int id = 1;
    int passengerId;
    String passengerName;
    String berthPreference;
    int age;
    char gender;

    Passenger(String passengerName,String berthPreference,int age, char gender){
        this.passengerId = id++;
        this.passengerName = passengerName;
        this.berthPreference = berthPreference;
        this.age = age;
        this.gender = gender;

    }
}
