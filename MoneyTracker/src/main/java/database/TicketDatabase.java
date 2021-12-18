package database;

import model.ticket;
import register_entry.RegisterEntry;

import java.util.Observable;

public abstract class TicketDatabase extends Observable {


    public abstract void AddTicket(ticket t, RegisterEntry entry);

    public abstract void DeleteTicket(ticket t, RegisterEntry entry);
}
