package controller;

import database.PersonDatabase;
import model.person;
import model.ticket;
import register_entry.RegisterEntry;

public class PersonController implements Controller{
    private final PersonDatabase pdb;

    public PersonController(PersonDatabase pdb){
        this.pdb = pdb;
    }

    @Override
    public void addTicket(ticket t) {

    }

    @Override
    public void addPerson(person p) {
        RegisterEntry entry = new RegisterEntry(true);
        pdb.AddPerson(p, entry);
    }

    @Override
    public void removeTicket(ticket t) {

    }

    @Override
    public void removePerson(person p) {
        RegisterEntry entry = new RegisterEntry(false);
        pdb.DeletePerson(p, entry);
    }
}
