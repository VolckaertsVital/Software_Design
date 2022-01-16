package controller;

import database.PersonDB;
import database.PersonDatabase;
import database.TicketDB;
import database.TicketDatabase;
import factory.AbstractFactory;
import factory.FactoryProvider;
import model.person;
import model.ticket;
import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;

import static java.lang.Math.abs;
import static org.junit.Assert.*;

public class CalculateBill_ITest {
    PersonController controller;
    TicketController controller2;
    ticket ticket1;
    person person1;
    person person2;
    person person3;

    public CalculateBill_ITest(){

    }

    @Before
    public void inittialize(){
        PersonDatabase P_DB = PersonDB.getInstance();
        TicketDatabase T_DB = TicketDB.getInstance();
        controller = new PersonController(P_DB);
        controller2 = new TicketController(T_DB);
        AbstractFactory factory = FactoryProvider.getMainFactory();
        person1 = factory.getPerson("Kevin", 0.0);
        person2 = factory.getPerson("Cedric", 0.0);
        person3 = factory.getPerson("Jens", 0.0);
        controller.addPerson(person1);
        controller.addPerson(person2);
        controller.addPerson(person3);
        ArrayList<person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        ticket1 = factory.getTicket(1, 15.0, "Cinema", "Film tickets", person1, true, personList);
    }


    @Test
    public void t_calculateBalance()
    {
        controller2.CalculateBalance(ticket1);
        assertEquals("Testing calculateBalance: Person1 should have a balance of 10€", 10.0, (double) Math.round(person1.getSpend() * 100) / 100.0, 0.002);
        assertEquals("Testing calculateBalance: Person2 should have a balance of 10€", -5.0, (double) Math.round(person2.getSpend() * 100) / 100.0, 0.002);
        assertEquals("Testing calculateBalance: Person3 should have a balance of 10€", -5.0, (double) Math.round(person3.getSpend() * 100) / 100.0, 0.002);
    }

    @Test
    public void t_calculateBill()
    {
        controller2.CalculateBalance(ticket1);
        controller2.CalculateBill(ticket1);
        assertEquals("Testing calculateBill: Person2 should pay person1 5€", 5.0, (double) Math.round(abs(person2.getSpend() * 100)) / 100.0, 0.002);
        assertEquals("Testing calculateBill: Person3 should pay person1 5€", 5.0, (double) Math.round(abs(person3.getSpend() * 100)) / 100.0, 0.002);
    }
}
