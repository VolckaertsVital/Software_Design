package controller;

import database.TicketDatabase;
import model.person;
import model.ticket;
import register_entry.RegisterEntry;

import java.util.ArrayList;

public class TicketController implements Controller{
    private final TicketDatabase tdb;
    ticket t;
    boolean splitEven = t.isSplitEven();
    double amount = t.getAmount();
    ArrayList<person> lendFor = t.getLend();
    int personCount = lendFor.size();
    person paidBy = t.getPaidBy();




    public TicketController(TicketDatabase tdb){
        this.tdb = tdb;

    }
    public void calculateBalance(){



        if (splitEven){ //deelt het bedrag door het aantal personen in de groep en voegt het toe aan hun balance(getSpend)

            double amountPerPerson = amount/personCount;
            for (person i : lendFor){
                i.setSpend(i.getSpend() + amountPerPerson);
                System.out.println(i.getName() + " balance :" + Math.round(i.getSpend() * 100) / 100.0 + "€");
            }

        }
        else{  //deelt het bedrag door het aantal personen in de groep behalve de persoon die betaald heeft en voegt het toe aan hun balance(getSpend)
            double amountPerPerson = amount / (personCount - 1);
            for (person i : lendFor){
                if (i.getName().equals(paidBy.getName())){
                    i.setSpend(i.getSpend());
                }
                else{
                    i.setSpend(i.getSpend() + amountPerPerson);
                }
                System.out.println(i.getName() + " balance :" + Math.round(i.getSpend() * 100) / 100.0 + "€");
            }
        }
    }

    public void CalculateBill(){

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

   public void balance(){
        if (splitEven){

        }
        else {

        }
   }



}
