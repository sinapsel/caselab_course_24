package org.caselab.task3;

public final class Car extends Vehicle implements IMechanicable {
    private final CarEngine engine;

    public Car(String name, int capacity, CarEngine engine) {
        super(name, capacity);
        this.engine = engine;

        this.wheels.add(new Wheel(16));
        this.wheels.add(new Wheel(16));
        this.wheels.add(new Wheel(16));
        this.wheels.add(new Wheel(16));

    }

    @Override
    public void move() {
        try {
            this.engine.use();
            System.out.println(name + " is driving on the road.");

        }
        catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public String toString() {
        return "Car{" +
                "engine=" + engine +
                ", name='" + name + '\'' +
                ", wheels=" + wheels +
                ", capacity=" + capacity +
                '}';
    }

    public CarEngine getEngine() {
        return engine;
    }
}
