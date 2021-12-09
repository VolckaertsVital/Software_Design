package UI;

import controller.PersonAndTicketController;

import javax.swing.*;

public class UserInterface extends JFrame {

    PersonAndTicketController controller;

    public UserInterface(PersonAndTicketController controller){
        super("MoneyTracker");
        this.controller = controller;
    }

}
