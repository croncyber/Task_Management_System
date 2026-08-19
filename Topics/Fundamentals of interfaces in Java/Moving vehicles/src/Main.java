// do not change the interfaces
interface Move {
    default void move(){
        System.out.println("Object moved from point A to point B");
    };
}

interface Fuel {
    default void refuel(){
        System.out.println("Object have been refueled!");
    };
}

interface Capacity {
    default void pickup(){
        System.out.println("Passengers picked up");
    };

    default void dropoff(){
        System.out.println("Passengers dropped off");
    }
}

class Bus implements ... {
    public void transport() {
        ...
    }
}

class Bicycle implements ... {
    public void transport() {
        ...
    }
}