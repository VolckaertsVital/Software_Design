package database;

import model.person;
import model.ticket;
import register_entry.RegisterEntry;

import java.util.HashMap;

public class PersonDB extends Database{

    private final HashMap<person, RegisterEntry> db;

    private static PersonDB instance;

    private PersonDB()
    {
        this.db = new HashMap<>();
    }
    //singleton pattern
    public static PersonDB getInstance(){
        if(instance == null) {
            instance = new PersonDB();
        }
        return instance;
    }

    @Override
    public void AddPerson(person p, RegisterEntry entry) {
        this.db.put( p, entry);
        setChanged();
    }

    @Override
    public void AddTicket(ticket t, RegisterEntry entry) {

    }



}
