package Sample;

class Passenger {
    String details;
    int id;
    int bookedTickets;
    double costPaid;



    Passenger(String details, int id, int bookedTickets, double costPaid){
        this.details = details;
        this.id = id;
        this.bookedTickets = bookedTickets;
        this.costPaid = costPaid;
    }


    public int getBookedTickets() {
        return bookedTickets;
    }

    public double getCostPaid() {
        return costPaid;
    }

    public int getId() {
        return id;
    }

    public String getDetails() {
        return details;
    }


}


