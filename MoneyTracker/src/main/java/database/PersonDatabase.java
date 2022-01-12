package database;

import model.person;
import register_entry.RegisterEntry;

import java.util.Observable;

public abstract class PersonDatabase extends Observable {

    public abstract void AddPerson(person p, RegisterEntry entry);

    public abstract void DeletePerson(person p, RegisterEntry entry);

    public abstract RegisterEntry getUserEntry(person person);
}
