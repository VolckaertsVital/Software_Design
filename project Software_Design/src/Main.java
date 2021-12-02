package Main;

import Database.Database;
import Database.PersonsDB;
import Database.TicketsDB;

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
        Database P_DB = PersonsDB.getInstance();
        Database T_DB = TicketsDB.getInstance();

    }



}