package model;

public class person {

    public int ID;
    public String FirstName;
    public String LastName;
    public double Spend;
    public ticket ticket;

    public person(String _FirstName, String _LastName, double _Spend)
    {
        this.FirstName = _FirstName;
        this.LastName = _LastName;
        this.Spend = _Spend;
    }

    public String GetFullName() {
        return FirstName + LastName;
    }
}
