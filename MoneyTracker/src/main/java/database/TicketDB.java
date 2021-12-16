package database;

import model.person;
import model.ticket;
import register_entry.RegisterEntry;

import java.util.HashMap;

public class TicketDB extends Database{

    private final HashMap<ticket, RegisterEntry> db;

    private static TicketDB instance;

    private TicketDB()
    {
        this.db = new HashMap<ticket, RegisterEntry>();
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
    public void DeletePerson(person p, RegisterEntry entry) {

    }

    @Override
    public void AddTicket(ticket t, RegisterEntry entry) {
        this.db.put(t, entry);
        setChanged();
    }

    @Override
    public void DeleteTicket(ticket t, RegisterEntry entry) {
        this.db.remove( t, entry);
        setChanged();
    }


}
