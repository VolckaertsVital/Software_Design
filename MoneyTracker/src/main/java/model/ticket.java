package model;

import java.util.ArrayList;

public class ticket {
    public int ID;
    public double Amount;
    public String Title;
    public String Description;
    public person PaidBy;
    public boolean SplitEven;
    public ArrayList LendFor;

    public ticket(double Amount, String Title, String Description, person PaidBy, boolean SplitEven, ArrayList LendFor){
        this.Amount = Amount;
        this.Title = Title;
        this.Description = Description;
        this.PaidBy = PaidBy;
        this.SplitEven = SplitEven;
        this.LendFor = LendFor;
    }

    public String getInfo(){
        return Title + Description + Amount + PaidBy + LendFor;
    }

    public boolean isSplitEven() {
        return SplitEven;
    }

    public double getAmount() {
        return Amount;
    }

    public ArrayList getLend() {
        return LendFor;
    }

    public person getPaidBy() {
        return PaidBy;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

}
