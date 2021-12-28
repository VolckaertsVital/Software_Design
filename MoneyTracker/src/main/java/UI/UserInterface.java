package UI;

import UI.Panels.ButtonPanel;
import UI.Panels.ListPanel;
import controller.PersonAndTicketController;

import javax.swing.*;
import java.awt.*;

public class UserInterface extends JFrame {

    PersonAndTicketController controller;
    ListPanel listPanel;
    ButtonPanel buttonPanel;

    public UserInterface(PersonAndTicketController controller){
        super("MoneyTracker");
        this.controller = controller;
    }

    public void init(){
        this.setSize(700, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout); //https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html#gridbag
        buttonPanel = new ButtonPanel(controller);
        listPanel = new ListPanel();

        //this.add(buttonPanel);
        this.add(listPanel);
        this.setVisible(true);
    }

}
