package dio.quebec;

import dio.quebec.facade.Facade;
import dio.quebec.singleton.EagerSingleton;
import dio.quebec.singleton.HolderSingleton;
import dio.quebec.singleton.LazySingleton;
import dio.quebec.strategy.*;

public class Main {

    public static void main(String[] args) {
        SingletonCheck();
        StrategyCheck();
        FacadeCheck();
    }

    private static void SingletonCheck() {
        LazySingleton lazySingleton = LazySingleton.getInstance();
        System.out.println(lazySingleton);
        lazySingleton = LazySingleton.getInstance();
        System.out.println(lazySingleton);

        EagerSingleton eagerSingleton = EagerSingleton.getInstance();
        System.out.println(eagerSingleton);
        eagerSingleton = EagerSingleton.getInstance();
        System.out.println(eagerSingleton);

        HolderSingleton holderSingleton = HolderSingleton.getInstance();
        System.out.println(holderSingleton);
        holderSingleton = HolderSingleton.getInstance();
        System.out.println(holderSingleton);
    }

    private static void StrategyCheck() {
        IBehaviour regular = new RegularBehaviour();
        IBehaviour defensive = new DefensiveBehaviour();
        IBehaviour agressive = new AgressiveBehaviour();

        Robot robot = new Robot();

        robot.setBehaviour(regular);
        robot.move();
        robot.move();

        robot.setBehaviour(defensive);
        robot.move();

        robot.setBehaviour(agressive);
        robot.move();
        robot.move();
        robot.move();
    }

    private static void FacadeCheck() {
        Facade facade = new Facade();
        facade.migrateClient("Test Client", "04.321-002");
    }
}