package Controller;


import Database.Database;

public class TicketsController implements Controller{


    private Database db;

    public TicketsController(Database db){
        this.db = db;
    }
}
