package observers;

import database.PersonDB;
import database.PersonDatabase;
import model.person;
import register_entry.RegisterEntry;

import java.util.Observable;
import java.util.Observer;

public class PersonObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        person p = (person) arg;
        String name = p.getName();
        //RegisterEntry entry = PersonDB.getInstance().AddPerson((person) arg);
        System.out.println("new user:" + name);


    }
}
