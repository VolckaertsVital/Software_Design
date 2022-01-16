package controller;


import model.person;
import model.ticket;

public interface Controller
{

    //methode add ticket
    void addTicket(ticket t);

    //methode add person
    void addPerson(person p);

    //methode remove ticket
    void removeTicket(ticket t);

    //methode remove person
    void removePerson(person p);

    void CalculateBalance(ticket t);

    void CalculateBill(ticket t);
}
