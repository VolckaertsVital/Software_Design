package database;

public class TicketDB {

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
