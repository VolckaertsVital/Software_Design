package Model;

import model.ticket;

public class Person {

    public int ID;
    public String FirstName;
    public String LastName;
    public double Spend;
    public ticket Ticket;

    public Person(String _FirstName, String _LastName, double _Spend)
    {
        this.FirstName = _FirstName;
        this.LastName = _LastName;
        this.Spend = _Spend;
    }

    public String GetFullName() {
        return FirstName + LastName;
    }
}
