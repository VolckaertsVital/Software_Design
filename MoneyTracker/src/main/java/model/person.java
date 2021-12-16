package model;

public class person {

    public int ID;
    public String FirstName;
    public String LastName;
    public double Spend;
    public ticket Ticket;

    public person(String FirstName, String LastName, double Spend, ticket Ticket)
    {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Spend = Spend;
        this.Ticket = Ticket;
    }

    public String GetFullName() {
        return FirstName + LastName;
    }
}
