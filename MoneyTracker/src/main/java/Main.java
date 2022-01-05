import UI.UserInterface;
import controller.PersonController;
import controller.TicketController;
import database.*;


import factory.AbstractFactory;
import factory.ModelFactory;
import model.person;
import observers.PersonObserver;
import observers.UpdateObserver;

public class Main
{
    public static void main(String[] args)
    {
        Main main = new Main();
        main.run();
    }

    public Main()
    {

    }

    public void run() {

        PersonDatabase P_DB = PersonDB.getInstance();
        TicketDatabase T_DB = TicketDB.getInstance();
        PersonController controller = new PersonController(P_DB);
        TicketController controller2 = new TicketController(T_DB);
        UserInterface ui = new UserInterface(controller, controller2);
        ui.init();
        UpdateObserver obs1 = new UpdateObserver();
        PersonObserver obs2 = new PersonObserver();

        P_DB.addObserver(obs1);
        P_DB.addObserver(obs2);
        P_DB.addObserver(ui);

    }

}
