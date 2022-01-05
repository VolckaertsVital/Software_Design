package database;

import model.person;
import model.ticket;
import register_entry.RegisterEntry;
import register_entry.RegisterEntryNull;

import java.util.HashMap;

public class PersonDB extends PersonDatabase{

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
        //checking if name already exist
        if(db.containsKey(p))
        {
            System.out.println("this name already exist in group. choose other name.");
        }
        else{
            //add name to hashmap
            this.db.put( p, entry);
            setChanged();
            notifyObservers(p);
        }


    }

    @Override
    public void DeletePerson(person p, RegisterEntry entry) {
        this.db.remove(p , entry);
        setChanged();
        notifyObservers(p);
    }

    @Override
    public RegisterEntry getUserEntry(person pers) {
        return this.db.getOrDefault(pers, new RegisterEntryNull()); //  used to get the value mapped with specified key
    }
}