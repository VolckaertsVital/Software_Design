package database;

public class TicketDB extends Database{

    private static TicketDB instance;

    private TicketDB()
    {
    }

    public static TicketDB getInstance(){
        if(instance == null) {
            instance = new TicketDB();
        }
        return instance;
    }
}
