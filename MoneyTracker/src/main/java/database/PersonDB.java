package database;

public class PersonDB {

    private static PersonDB instance;

    private PersonDB()
    {
    }

    public static PersonDB getInstance(){
        if(instance == null) {
            instance = new PersonDB();
        }
        return instance;
    }

}
