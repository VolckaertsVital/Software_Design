package UI.Panels;

import controller.PersonAndTicketController;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {

    private static PersonAndTicketController controller;

    private final JTextField userName;
    private final JLabel userCount;


    private int userCounter = 0;
    private int ticketCount = 0;


    public ButtonPanel(PersonAndTicketController controller) {

        this.controller = controller;

        userCount = new JLabel("Users: " + userCounter);
        userCount.setPreferredSize(new Dimension(75, 25));
        this.add(userCount);
        JLabel userLabel = new JLabel("Add/Remove user: ");
        this.add(userLabel);
        userName = new JTextField();
        this.add(userName);

    }
}
