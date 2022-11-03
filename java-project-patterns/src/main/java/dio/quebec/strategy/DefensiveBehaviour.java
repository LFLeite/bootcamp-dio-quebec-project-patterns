package dio.quebec.strategy;

public class DefensiveBehaviour implements IBehaviour{
    @Override
    public void move() {
        System.out.println("Defensive movement...");
    }
}
