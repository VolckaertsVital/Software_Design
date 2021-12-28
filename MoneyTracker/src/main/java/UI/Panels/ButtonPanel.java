package UI.Panels;


import controller.PersonController;
import controller.TicketController;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {

    private static PersonController p_controller;
    private static TicketController t_controller;

    private final JTextField ticketType;
    private final JTextField userName;
    private final JTextField ticketPriceField;
    private final JTextField ticketPaidBy;
    private final JTextField paidForTextfield;

    private final JCheckBox boxsplitEven;
    private final JCheckBox boxsplitOdd;


    private final JLabel userCount;
    private final JLabel ticketCount;

    private final JButton addUser;
    private final JButton removeUser;
    private final JButton addTicket;


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

        JLabel ticketLabel = new JLabel("Ticket Type:");
        ticketLabel.setPreferredSize(new Dimension(75, 25));
        this.add(ticketLabel);

        ticketType = new JTextField();
        this.add(ticketType);

        JLabel ticketPriceLabel = new JLabel("Price: ");
        ticketPriceLabel.setPreferredSize(new Dimension(75, 25));
        this.add(ticketPriceLabel);

        ticketPriceField = new JTextField();
        ticketPriceField.setPreferredSize(new Dimension(75, 25));
        this.add(ticketPriceField);

        JLabel ticketPaidByLabel = new JLabel("Paid By : ");
        ticketPaidByLabel.setPreferredSize(new Dimension(75, 25));
        this.add(ticketPaidByLabel);

        ticketPaidBy = new JTextField();
        ticketPaidBy.setPreferredSize(new Dimension(75, 25));
        this.add(ticketPaidBy);

        boxsplitEven = new JCheckBox("Split Even");
        boxsplitEven.setPreferredSize(new Dimension(10, 10));
        this.add(this.boxsplitEven);

        boxsplitOdd = new JCheckBox("Split Odd");
        boxsplitOdd.setPreferredSize(new Dimension(10, 10));
        this.add(this.boxsplitOdd);

        JLabel paidForLabel = new JLabel("Paid For : (fill in if split odd is checked, seperate users with a , )");
        paidForLabel.setPreferredSize(new Dimension(75, 25));
        this.add(paidForLabel);

        paidForTextfield = new JTextField();
        paidForTextfield.setPreferredSize(new Dimension(75, 25));
        this.add(paidForTextfield);


        addTicket = new JButton("Confirm");
        addTicket.setPreferredSize(new Dimension(75, 25));
        this.add(this.addTicket);
    }
}
