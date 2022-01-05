package UI;

import UI.Panels.ButtonPanel;
import UI.Panels.ListPanel;
import controller.PersonController;
import controller.TicketController;
import database.TicketDatabase;
import database.PersonDatabase;
import database.PersonDB;
import database.TicketDB;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import model.person;
import model.ticket;

public class UserInterface extends JFrame implements Observer {

    PersonController p_controller;
    TicketController t_controller;
    ListPanel listPanel;
    ButtonPanel buttonPanel;

    public UserInterface(PersonController pcontroller, TicketController tcontroller){
        super("MoneyTracker");
        this.p_controller = pcontroller;
        this.t_controller = tcontroller;
    }

    public void init(){
        this.setSize(700, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout); //https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html#gridbag
        buttonPanel = new ButtonPanel(p_controller, t_controller);
        listPanel = new ListPanel();

        this.add(buttonPanel);
        this.add(listPanel);
        this.setVisible(true);
    }

    @Override
    public void update(Observable observable, Object o)
    {
        if(o instanceof person)
            this.listPanel.addEntry(PersonDB.getInstance().getUserEntry((person) o));
        else
            this.listPanel.addEntry(TicketDB.getInstance().getTicketEntry((ticket) o));

    }

}
