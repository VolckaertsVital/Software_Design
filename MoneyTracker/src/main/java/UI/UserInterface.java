package UI;

import UI.Panels.ButtonPanel;
import UI.Panels.ListPanel;
import controller.PersonController;
import controller.TicketController;

import javax.swing.*;
import java.awt.*;

public class UserInterface extends JFrame {

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

        //this.add(buttonPanel);
        this.add(listPanel);
        this.setVisible(true);
    }

}
