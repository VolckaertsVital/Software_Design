package UI.Panels;

import register_entry.RegisterEntry;
import model.person;

import javax.swing.*;

public class ListPanel extends JPanel{

    private static DefaultListModel<RegisterEntry> entryListModel;
    //DefaultListModel is just a list implementation used for JList.
    //https://stackoverflow.com/questions/13136826/defaultlistmodel-in-java
    public ListPanel(){
        JLabel label = new JLabel("Registrations");
        entryListModel = new DefaultListModel<>();
        JList<RegisterEntry> entryJlist = new JList<>(entryListModel);
        this.add(label);
        this.add(entryJlist);
    }

    public void addEntry(RegisterEntry register){
        this.entryListModel.addElement(register);
    }
}

