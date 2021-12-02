package Model;

public class Group {
    public int ID;
    public String GroupName;
    public double TotalSpend;
    public Person person;

    public Group(String _GroupName, double _TotalSpend)
    {
        this.GroupName = _GroupName;
        this.TotalSpend = _TotalSpend;
    }

    public double GetTotalSpend(){
        return TotalSpend;
    }
}
