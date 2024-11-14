package org.caselab.task3;

public final class AirplaneEngine extends Engine {
    public AirplaneEngine(EFuel fuel, int power) {
        super(fuel, power);
    }

    @Override
    public void fillWithFuel(EFuel fuel) {
        this.fuelLevel = EFuelLevel.FULL;
    }
}
