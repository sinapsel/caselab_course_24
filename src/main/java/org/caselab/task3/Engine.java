package org.caselab.task3;

public abstract sealed class Engine implements IMover permits CarEngine, AirplaneEngine, ShipEngine {
    private final EFuel fuel;
    private final int power;

    protected EFuelLevel fuelLevel;

    protected boolean engineStatus;

    public Engine(EFuel fuel, int power) {
        this.fuel = fuel;
        this.power = power;
        this.fuelLevel = EFuelLevel.EMPTY;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "fuel=" + fuel +
                ", power=" + power +
                ", fuelLevel=" + fuelLevel +
                ", engineStatus=" + engineStatus +
                '}';
    }

    @Override
    public void ignite() {
        if (!engineStatus)
            engineStatus = true;
    }

    @Override
    public void turnOff() {
        if (engineStatus)
            engineStatus = false;
    }

    public void use() {
        if (!engineStatus)
            throw new RuntimeException("Turn engine first!");
        if (fuelLevel == Engine.EFuelLevel.EMPTY)
            throw new RuntimeException("Fill the engine up first!");

        if (fuelLevel == Engine.EFuelLevel.LOW)
            System.out.println("AVOID, Low fuel level!");

        fuelLevel.next();
    }

    public EFuel getFuel() {
        return fuel;
    }


    public enum EFuelLevel {
        EMPTY{
            @Override
            public EFuelLevel next() {
                return null; // see below for options for this line
            }
        },
        LOW,
        MEDIUM,
        HIGH,
        FULL;

        public EFuelLevel next() {
            return values()[ordinal() - 1];
        }
    }
}


