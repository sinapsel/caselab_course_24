package org.caselab.task3;

public final class CarEngine extends Engine {
    public CarEngine(EFuel fuel, int power) {
        super(fuel, power);
    }

    @Override
    public void fillWithFuel(EFuel fuel) {
        this.fuelLevel = EFuelLevel.FULL;
    }
}
