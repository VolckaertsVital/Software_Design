package factory;

import model.person;
import model.ticket;

import java.util.ArrayList;

public interface AbstractFactory {
    person getPerson( String Name, Double Spend);

    ticket getTicket(int ID, double Amount, String Title, String Description, person Paid, boolean SplitEven, ArrayList Lend);
}
