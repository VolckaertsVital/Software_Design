package controller;

import database.TicketDatabase;
import model.person;
import model.ticket;
import register_entry.RegisterEntry;

public class TicketController implements Controller{
    private final TicketDatabase tdb;

    public TicketController(TicketDatabase tdb){
        this.tdb = tdb;
    }

    @Override
    public void addTicket(ticket t) {
        RegisterEntry entry = new RegisterEntry(true);
        tdb.AddTicket(t, entry);
    }

    @Override
    public void addPerson(person p) {

    }

    @Override
    public void removeTicket(ticket t) {
        RegisterEntry entry = new RegisterEntry(false);
        tdb.DeleteTicket(t, entry);
    }

    @Override
    public void removePerson(person p) {

    }


}
