package register_entry;

import java.util.Calendar;

public class RegisterEntry
{
    protected boolean checkedIn;

    public RegisterEntry(boolean checked)
    {
        this.checkedIn = checked;


    }



    public String toString()
    {
        if(this.checkedIn)
        {
            return String.format("checked in");
        } else
        {
            return String.format("checked out");
        }
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }
}
