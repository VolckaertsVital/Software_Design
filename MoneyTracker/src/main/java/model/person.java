package model;

public class person {

    public int ID;
    public String Name;
    public double Spend;

    public person(String Name, double Spend)
    {
        this.Name = Name;
        this.Spend = Spend;
        ID = ID + 1;
    }

    public String getName() {
        return Name;
    }
}
