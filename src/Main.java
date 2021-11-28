import Database.Database;
import Database.RegistrationDB;
import Model.Group;
import Model.Person;

public class Main
{
    public static void main(String[] args)
    {
        Main main = new Main();
        main.run();
    }

    public Main()
    {

    }

    public void run()
    {
        Database db = RegistrationDB.getInstance();

    }



}