package dio.quebec.strategy;

public class AgressiveBehaviour implements IBehaviour{
    @Override
    public void move() {
        System.out.println("Agressive movement...");
    }
}
