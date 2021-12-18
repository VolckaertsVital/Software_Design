package model;

import java.util.ArrayList;

public class ticket {
    public int ID;
    public double Amount;
    public String Title;
    public String Description;
    public person Paid;
    public boolean SplitEven;
    public ArrayList Lend;

    public ticket(double Amount, String Title, String Description, person Paid, boolean SplitEven, ArrayList Lend){
        this.Amount = Amount;
        this.Title = Title;
        this.Description = Description;
        this.Paid = Paid;
        this.SplitEven = SplitEven;
        this.Lend = Lend;
    }

    public String getInfo(){
        return Title + Description + Amount + Paid + Lend;
    }

    public boolean isSplitEven() {
        return SplitEven;
    }

    public double getAmount() {
        return Amount;
    }

    public ArrayList getLend() {
        return Lend;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

}
