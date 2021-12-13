package database;


import register_entry.RegisterEntry;
import model.ticket;
import model.person;

import java.util.Observable;

public abstract class Database extends Observable
{
    public Database() {

    }

    public abstract void AddPerson(person p, RegisterEntry entry);

    public abstract void DeletePerson(person p, RegisterEntry entry);



    public abstract void AddTicket(ticket t, RegisterEntry entry);

    public abstract void DeleteTicket(ticket t, RegisterEntry entry);
}
