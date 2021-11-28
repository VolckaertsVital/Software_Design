package Database;


import java.util.HashMap;

public class RegistrationDB extends Database
{
    private static RegistrationDB instance = new RegistrationDB();

    private RegistrationDB()
    {
    }

    public static RegistrationDB getInstance(){
        if(instance == null) {
            instance = new RegistrationDB();
        }
        return instance;
    }







}
