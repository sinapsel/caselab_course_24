package org.caselab.task3;

public final class Airplane extends Vehicle implements IMechanicable {
    private final AirplaneEngine engine;

    public Airplane(String name, int capacity, AirplaneEngine engine) {
        super(name, capacity);
        this.engine = engine;

        this.wheels.add(new Wheel(3));
        this.wheels.add(new Wheel(3));
        this.wheels.add(new Wheel(1));

    }

    @Override
    public void move() {
        try {
            this.engine.use();
            System.out.println(name + " is flying in the sky.");

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public String toString() {
        return "Airplane{" +
                "engine=" + engine +
                ", name='" + name + '\'' +
                ", wheels=" + wheels +
                ", capacity=" + capacity +
                '}';
    }

    @Override
    public AirplaneEngine getEngine() {
        return engine;
    }
}
