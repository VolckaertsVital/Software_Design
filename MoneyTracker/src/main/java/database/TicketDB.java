package database;

import model.person;
import model.ticket;
import register_entry.RegisterEntry;

public class TicketDB extends Database{

    private static TicketDB instance;

    private TicketDB()
    {
    }
    //singleton pattern
    public static TicketDB getInstance(){
        if(instance == null) {
            instance = new TicketDB();
        }
        return instance;
    }

    @Override
    public void AddPerson(person p, RegisterEntry entry) {

    }

    @Override
    public void AddTicket(ticket t, RegisterEntry entry) {

    }


}
