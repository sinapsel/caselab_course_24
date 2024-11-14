package org.caselab.task3;

public class VehicleFactory {
    public Vehicle createVehicle(EVehicleTypes type, String name, int capacity, Engine engine) {
        return switch (type) {
            case AIRPLANE -> new Airplane(name, capacity, (AirplaneEngine) engine);
            case CAR -> new Car(name, capacity, (CarEngine) engine);
            case BIKE -> new Bike(name, capacity);
            case SHIP -> new Ship(name, capacity, (ShipEngine) engine);
        };
    }

    public enum EVehicleTypes {
        AIRPLANE,
        CAR,
        BIKE,
        SHIP
    }
}
