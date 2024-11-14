package org.caselab.task3;

public final class ShipEngine extends Engine {
    public ShipEngine(EFuel fuel, int power) {
        super(fuel, power);
    }

    @Override
    public void fillWithFuel(EFuel fuel) {
        this.fuelLevel = EFuelLevel.FULL;
    }
}
