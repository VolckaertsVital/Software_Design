package Database;

import Model.Person;
import Model.Ticket;

public class PersonsDB extends Database{

        private static PersonsDB instance;

        private PersonsDB()
        {
        }



    public static PersonsDB getInstance(){
            if(instance == null) {
                instance = new PersonsDB();
            }
            return instance;
        }


}
