package Database;

public class TicketsDB extends Database{
    private static TicketsDB instance;

    private TicketsDB()
    {
    }

    public static TicketsDB getInstance(){
        if(instance == null) {
            instance = new TicketsDB();
        }
        return instance;
    }
}
