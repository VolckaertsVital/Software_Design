package controller;

import database.TicketDatabase;
import model.person;
import model.ticket;
import register_entry.RegisterEntry;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Math.abs;

public class TicketController implements Controller{
    private final TicketDatabase tdb;





    public TicketController(TicketDatabase tdb){
        this.tdb = tdb;
        ticket t = null;

    }

    @Override
    public void CalculateBalance(ticket t){
        double amount = t.getAmount();
        ArrayList<person> lendFor = t.getLend();
        int personCount = lendFor.size();
        person paidBy = t.getPaidBy();
        boolean splitEven = t.isSplitEven();



        if (splitEven){ //deelt het bedrag door het aantal personen in de groep en voegt het toe aan hun balance(getSpend)

            double amountPerPerson = amount/personCount;
            for (person i : lendFor){
                if (i.getName().equals(paidBy.getName())) {
                    i.setSpend(i.getSpend() + amountPerPerson * (personCount - 1.0));
                } else {
                    i.setSpend(i.getSpend() - amountPerPerson);
                }
                System.out.println(i.getName() + " balance :" + Math.round(i.getSpend() * 100) / 100.0 + "€");
            }

        }
        else{  //deelt het bedrag door het aantal personen in de groep behalve de persoon die betaald heeft en voegt het toe aan hun balance(getSpend)
            double amountPerUser = amount / personCount;
            paidBy.setSpend(paidBy.getSpend() + amount);
            System.out.println(paidBy.getName() + " balance :" + Math.round(paidBy.getSpend() * 100) / 100.0 + "€");
            for (person i : lendFor) {
                i.setSpend(i.getSpend() - amountPerUser);
                System.out.println(i.getName() + " balance :" + Math.round(i.getSpend() * 100) / 100.0 + "€");
            }
        }
    }
    @Override
    public void CalculateBill(ticket t){
        double amount = t.getAmount();
        ArrayList<person> lendFor = t.getLend();
        int personCount = lendFor.size();
        person paidBy = t.getPaidBy();
        boolean splitEven = t.isSplitEven();
        HashMap<person, Double> persons = new HashMap<>();
        ArrayList<person> allUsers = t.getLend();

        person mostPosPerson = null;
        person mostNegPerson = null;
        double mostPos;
        double mostNeg;

        for (person i : allUsers) {              // zet users in hashmap die balance niet op 0 hebben staan
            if (i.getSpend() != 0)
                persons.put(i, i.getSpend());
        }

        if (!splitEven) // zet betaler ook bij users als het oneven is gesplitst
        {
            if (paidBy.getSpend() != 0)
                persons.put(paidBy, paidBy.getSpend());
        }


        while (persons.size() >= 2) {
            mostPos = 0.00;
            mostNeg = 0.00;

            for (person i : persons.keySet()) {  // overloopt alle users


                if (persons.get(i) > mostPos) {

                    mostPosPerson = i;
                    mostPos = persons.get(i);

                }

                if (persons.get(i) < mostNeg) {
                    mostNegPerson = i;
                    mostNeg = persons.get(i);

                }
            }

            if (abs(mostPos) == abs(mostNeg)) {
                System.out.println(mostNegPerson.getName() + " has to pay " + Math.round(abs(mostNeg * 100)) / 100.0 + "€ to " + mostPosPerson.getName());
                persons.remove(mostNegPerson);
                persons.remove(mostPosPerson);
            } else if (abs(mostPos) < abs(mostNeg)) {
                System.out.println(mostNegPerson.getName() + " has to pay " + Math.round(abs(mostPos * 100)) / 100.0 + "€ to " + mostPosPerson.getName());
                persons.remove(mostPosPerson);
                persons.replace(mostNegPerson, persons.get(mostNegPerson) + mostPos);
            } else {
                System.out.println(mostNegPerson.getName() + " has to pay " + Math.round(abs(mostNeg * 100)) / 100.0 + "€ to " + mostPosPerson.getName());
                persons.remove(mostNegPerson);
                persons.replace(mostPosPerson, persons.get(mostPosPerson) - mostNeg);
            }


        }

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
