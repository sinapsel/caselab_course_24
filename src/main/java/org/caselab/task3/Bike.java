package org.caselab.task3;

public final class Bike extends Vehicle {

    public Bike(String name, int capacity) {
        super(name, capacity);

        this.wheels.add(new Wheel(32));
        this.wheels.add(new Wheel(32));

    }

    @Override
    public void move() {
        try {
            if (this.capacity.getCurrentCapacity() == 0)
                throw new RuntimeException("Nobody can drive the bike!");

            System.out.println(name + " is driving on the road.");

        }
        catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

    }
}
