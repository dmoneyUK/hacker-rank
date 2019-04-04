package hacker.rank.corejava;

import java.util.Random;

public class SingletonB {
    
    private int value;
    private static SingletonB instance = getInstance();
    
    private SingletonB() {
        this.value = new Random().nextInt(100);
    }
    
    public static SingletonB getInstance() {
        return instance == null ? new SingletonB() : instance;
    }
    
    public int getValue(){
        return value;
    }
}
