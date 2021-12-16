package Model;

public class Person {

    public int ID;
    public String FirstName;
    public String LastName;
    public double Spend;
    public Group group;
    public Ticket ticket;

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
