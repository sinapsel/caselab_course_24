package org.caselab.task3;

import java.util.ArrayList;

public abstract class Vehicle implements ITransportable {


    protected final String name;
    protected final ArrayList<Wheel> wheels;
    protected final Capacity capacity;

    public Vehicle(String name, int capacity) {
        this.name = name;
        this.capacity = new Capacity(capacity);
        this.wheels = new ArrayList<Wheel>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Wheel> getWheels() {
        return wheels;
    }

    public Capacity getCapacity() {
        return capacity;
    }



    public static class Wheel {
        private final int size;

        public Wheel(int size) {
            this.size = size;
        }

        @Override
        public String toString() {
            return "Wheel{" +
                    "size=" + size +
                    '}';
        }

    }

    public static class Capacity {
        private final int maximumCapacity;
        private int currentCapacity;

        public Capacity(int maximumCapacity) {
            this.currentCapacity = 0;
            this.maximumCapacity = maximumCapacity;
        }

        public int getCurrentCapacity() {
            return currentCapacity;
        }

        public int getMaximumCapacity() {
            return maximumCapacity;
        }

        public Capacity takeSeat() {
            if (currentCapacity == maximumCapacity)
                throw new RuntimeException("Full Vehicle!");
            currentCapacity++;
            return this;
        }

    }
}
