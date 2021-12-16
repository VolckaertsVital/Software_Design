package controller;

import database.Database;
import model.person;
import model.ticket;
import register_entry.RegisterEntry;

public class PersonAndTicketController implements Controller{
    private final Database pdb;
    private final Database tdb;

    public PersonAndTicketController(Database pdb, Database tdb){

        this.pdb = pdb;
        this.tdb = tdb;
    }

    @Override
    public void addTicket(ticket t) {
        RegisterEntry entry = new RegisterEntry(true);

    }

    @Override
    public void addUser(person p) {

    }

    @Override
    public void removeTicket(ticket t) {

    }

    @Override
    public void removePerson(person p) {

    }
}

