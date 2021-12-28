package factory;

import model.person;
import model.ticket;

import java.util.ArrayList;

public class ModelFactory implements AbstractFactory{


    @Override
    public person getPerson(String Name, Double Spend) {
        return new person( Name, Spend);
    }

    @Override
    public ticket getTicket(int ID, double Amount, String Title, String Description, person PaidBy, boolean SplitEven, ArrayList LendFor) {
        return new ticket(Amount, Title, Description, PaidBy, SplitEven, LendFor);
    }
}
