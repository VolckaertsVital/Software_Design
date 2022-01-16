package iterator;

import model.person;

import java.util.ArrayList;

public interface Container {
    public Iterator getIterator(ArrayList<person> userList);
}
