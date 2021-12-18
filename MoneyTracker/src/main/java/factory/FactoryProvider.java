package factory;

public class FactoryProvider {
    public static  AbstractFactory getMainFactory(){
        return new ModelFactory();
    }
}
