package org.caselab.task3;

public class EngineFactory {
    public Engine createEngine(EEngineTypes type, EFuel fuel, int power) {
        return switch (type) {
            case AIRPLANE -> new AirplaneEngine(fuel, power);
            case CAR -> new CarEngine(fuel, power);
            case SHIP -> new ShipEngine(fuel, power);
            case NONE -> null;
        };
    }

    public enum EEngineTypes {
        AIRPLANE,
        CAR,
        SHIP,
        NONE
    }
}
