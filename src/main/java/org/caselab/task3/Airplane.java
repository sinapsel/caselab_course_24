package org.caselab.task3;

public final class Airplane extends Vehicle {
    private final AirplaneEngine engine;

    public Airplane(String name, int capacity, AirplaneEngine engine) {
        super(name, capacity);
        this.engine = engine;
    }

    @Override
    public void move() {
        try {
            this.engine.use();
        }
        catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

        System.out.println(name + " is flying in the sky.");

    }


}
