package UI.Panels;


import controller.PersonController;
import controller.TicketController;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {

    private static PersonController p_controller;
    private static TicketController t_controller;
    private final JTextField userName;

    private final JLabel userCount;
    private final JLabel ticketCount;

    private final JButton addUser;
    private final JButton removeUser;


    private int userCounter = 0;
    private int ticketCounter = 0;


    public ButtonPanel(PersonController pcontroller, TicketController tcontroller) {

        this.p_controller = pcontroller;
        this.t_controller = tcontroller;

        userCount = new JLabel("Users: " + userCounter);
        userCount.setPreferredSize(new Dimension(75, 25));
        this.add(userCount);
        JLabel userLabel = new JLabel("Add/Remove user: ");
        this.add(userLabel);
        userName = new JTextField();
        this.add(userName);

        addUser = new JButton(" + ");
        addUser.setPreferredSize(new Dimension(25, 25));
        this.add(addUser);

        removeUser = new JButton(" - ");
        removeUser.setPreferredSize(new Dimension(25, 25));
        this.add(removeUser);

        ticketCount = new JLabel("Tickets: " + ticketCounter);
        ticketCount.setPreferredSize(new Dimension(75, 25));
        this.add(ticketCount);


    }
}
