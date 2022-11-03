package dio.quebec.strategy;

public class Robot {
    private IBehaviour behaviour;

    public void setBehaviour(IBehaviour behaviour) {
        this.behaviour = behaviour;
    }

    public void move() {
        behaviour.move();
    }
}
