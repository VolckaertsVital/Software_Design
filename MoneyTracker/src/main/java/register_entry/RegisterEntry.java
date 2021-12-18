package register_entry;

import java.util.Calendar;

public class RegisterEntry
{
    protected boolean checkedIn;

    public RegisterEntry(boolean checkedIn)
    {
        this.checkedIn = checkedIn;


    }



    @Override
    public String toString()
    {
        String status;

        if(this.checkedIn)
        {
            status = "in";
        } else
        {
            status = "out";
        }

        return String.format("checked %s ", status);
    }
}
