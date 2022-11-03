package dio.quebec.strategy;

public class RegularBehaviour implements IBehaviour{
    @Override
    public void move() {
        System.out.println("Regular movement...");
    }
}
