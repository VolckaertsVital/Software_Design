package UI.Panels;


import controller.PersonController;
import controller.TicketController;
import factory.AbstractFactory;
import factory.FactoryProvider;

import model.person;
import model.ticket;

import javax.swing.*;
import javax.xml.bind.Marshaller;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

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

    private double ticketPrice = 0;

    private String input;
    private String typeTicket;
    private String paidBy;

    private String paidFor;
    private String[] paidForArray;

    private boolean foundUser;
    private boolean splitEven;


    private person person;
    private person paidForUser;
    private ticket ticket;
    HashMap<Integer, person> UserHash = new HashMap<>();

    ArrayList<person> splitOddList = new ArrayList<>();
    ArrayList<person> allUsers = new ArrayList<>();

    private boolean error;
    private boolean foundUserToRemove = false;
    private boolean foundPaidFor = false;

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
        boxsplitEven.setPreferredSize(new Dimension(10, 25));
        this.add(this.boxsplitEven);

        boxsplitOdd = new JCheckBox("Split Odd");
        boxsplitOdd.setPreferredSize(new Dimension(10, 25));
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

        addingUser();
        removingUser();
        addingTicket();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    }

    public void addingUser() {
        this.addUser.addActionListener(Listener ->
        {
            input = userName.getText();
            if(input.equals("")) {
                JOptionPane.showMessageDialog(null, "Name Required!");
            } else {
                userCounter++;
                userCount.setText("Users: " + userCounter);
                AbstractFactory factory = FactoryProvider.getMainFactory();
                this.person = factory.getPerson(input, 0.0);
                UserHash.put(userCounter, person);
                allUsers.add(person);
                p_controller.addPerson(person);

            }
        });
    }

    public void addingTicket(){
        this.addTicket.addActionListener(listener ->
        {
            error = false;

            typeTicket = ticketType.getText();
            paidBy = ticketPaidBy.getText();


            if (ticketType.getText().length() <= 0 || ticketPaidBy.getText().length() <= 0 || ticketPriceField.getText().length() <= 0) {
                JOptionPane.showMessageDialog(null, "Textbox Empty!");
                error = true;
            }

            for (int i : UserHash.keySet()) {

                if (paidBy.equals(UserHash.get(i).getName())) { // als de naam van een user in de hashmap & database overeenkomt met de ingetypte naam in de gui.
                    person = UserHash.get(i);
                    foundUser = true;
                }

            }

            ticketPrice = Double.parseDouble((ticketPriceField.getText()));

            if (boxsplitEven.isSelected() && boxsplitOdd.isSelected()) {
                JOptionPane.showMessageDialog(null, "You can't check both boxes!");
                error = true;
            } else splitEven = boxsplitEven.isSelected();

            if (splitEven) {
                if (foundUser && ticketType.getText().length() > 0 && ticketPaidBy.getText().length() > 0 && ticketPriceField.getText().length() > 0 && !error) {

                    ticketCounter++;
                    ticketCount.setText("# Tickets : " + ticketCount);
                    AbstractFactory factory = FactoryProvider.getMainFactory();
                    this.ticket = factory.getTicket(ticketCounter, ticketPrice, typeTicket, typeTicket, person, splitEven, allUsers); // paid for all users
                    t_controller.addTicket(ticket);
                    foundUser = false;
                } else {

                    JOptionPane.showMessageDialog(null, "Make sure you filled everything in correctly!");
                }

            } else // ticket is niet even gesplit
            {
                paidFor = paidForTextfield.getText();
                paidForArray = paidFor.split(","); //

                foundPaidFor = false;

                splitOddList.clear();
                for (int i : UserHash.keySet()) {
                    for (int j = 0; j <= paidForArray.length - 1; j++) // Voor alle users in de String
                    {
                        if (paidForArray[j].equals(UserHash.get(i).getName())) { // als de naam van een user in de hashmap & database overeenkomt met de ingetypte naam in de gui.
                            paidForUser = UserHash.get(i);
                            splitOddList.add(paidForUser);
                            foundPaidFor = true;
                        }

                    }
                }

                if (splitOddList.size() == 0)
                    foundPaidFor = false;


                if (!foundPaidFor && !splitEven) {
                    JOptionPane.showMessageDialog(null, "There is no user with the name " + paidFor);
                    error = true;
                }


                if (!splitEven && paidFor.equals("")) {
                    JOptionPane.showMessageDialog(null, "Fill in the users you have paid for!");
                    error = true;
                }


                if (foundUser && ticketType.getText().length() > 0 && ticketPaidBy.getText().length() > 0 && ticketPriceField.getText().length() > 0 && foundPaidFor && !error) {

                    ticketCounter++;
                    ticketCount.setText("# Tickets : " + ticketCount);
                    AbstractFactory factory = FactoryProvider.getMainFactory();
                    this.ticket = factory.getTicket(ticketCounter, ticketPrice, typeTicket, typeTicket, person, splitEven, splitOddList);
                    t_controller.addTicket(ticket);
                    foundUser = false;
                    error = false;
                } else {

                    JOptionPane.showMessageDialog(null, "Make sure you filled everything in correctly!");
                }

            }


        });
        
    }

    public void removingUser() {
        this.removeUser.addActionListener(listener ->
        {
            String nameUser = userName.getText();

            for (int i : UserHash.keySet()) {

                if (nameUser.equals(UserHash.get(i).getName())) { // als de naam van een user in de hashmap & database overeenkomt met de ingetypte naam in de gui.
                    p_controller.removePerson(person);
                    userCounter--;
                    userCount.setText("Users: " + userCounter);
                    foundUserToRemove = true;
                }

            }
            if (!foundUserToRemove)
                JOptionPane.showMessageDialog(null, "There is no user with the name " + nameUser);

        });
        foundUserToRemove = false;
    }
}
