package org.caselab.task3;


/*
Необходимо создать иерархию классов для описания нескольких видов транспорта.
[+] В иерархию должны быть включены как минимум 4 конечных вида транспорта. (например, автомобиль, самолет,
корабль, велосипед и т. д.).
[+] Пользователь должен иметь возможность создавать объекты разных видов транспорта, вызывать методы для каждого объекта и выводить информацию о транспорте на консоль.
[+] В иерархию также могут входить такие сущности, как двигатель, топливо и т. д


Требования:
[+] Реализовать пользовательский интерфейс на свое усмотрение
[+] Обязательно применение запечатанных (Sealed) классов и перечислений (Enum)
[+] Обязательно корректное применение абстрактных классов или интерфейсов для реализации
иерархии
[ ] Создать UML-диаграмму на основе полученной иерархии, на которой будут указаны отношения
между классами (наследование, реализация, ассоциация)
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        VehicleFactory vehicleFactory = new VehicleFactory();
        EngineFactory engineFactory = new EngineFactory();
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose garage size");
        int N = sc.nextInt();
        assert (N > 0);

        for (int i =0; i < N; ++i) {
            System.out.println("Enter vehicle name");
            String name = sc.next();

            System.out.println("Choose transport type:" + Arrays.toString(VehicleFactory.EVehicleTypes.values()));
            String vType = sc.next();

            VehicleFactory.EVehicleTypes vehicleType = VehicleFactory.EVehicleTypes.valueOf(vType.toUpperCase());

            System.out.println("Enter maximum capacity");
            int capacity = sc.nextInt();
            assert (capacity > 0);

            System.out.println("Enter engine type: " + Arrays.toString(EngineFactory.EEngineTypes.values()));
            String eType = sc.next();

            EngineFactory.EEngineTypes engineType = EngineFactory.EEngineTypes.valueOf(eType.toUpperCase());

            System.out.println("Enter fuel type: " + Arrays.toString(EFuel.values()));
            String fType = sc.next();
            EFuel fuelType = EFuel.valueOf(fType.toUpperCase());

            System.out.println("Enter engine power");
            int power = sc.nextInt();
            assert (power > 0);

            vehicles.add(
                    vehicleFactory.createVehicle(vehicleType, name, capacity,
                        engineFactory.createEngine(
                            engineType, fuelType, power
                        )
                )
            );

        }
        int idx;

        while ((idx = sc.nextInt()) != -1) {
            try {
                Vehicle v = vehicles.get(idx);
                System.out.println("Enter action type: " + Arrays.toString(EAction.values()));
                String aType = sc.next();
                EAction action = EAction.valueOf(aType.toUpperCase());

                switch (action) {
                    case STATUS -> System.out.println(v);
                    case SEAT -> System.out.println(v.capacity.takeSeat());
                    case MOVE -> v.move();
                    case ENGINE_ON -> {
                        if (IMechanicable.class.isAssignableFrom(v.getClass())) {
                            IMechanicable v1 = (IMechanicable) v;
                            v1.getEngine().ignite();
                        }
                    }
                    case ENGINE_OFF -> {
                        if (IMechanicable.class.isAssignableFrom(v.getClass())) {
                            IMechanicable v1 = (IMechanicable) v;
                            v1.getEngine().turnOff();
                        }
                    }
                    case FILL -> {
                        if (IMechanicable.class.isAssignableFrom(v.getClass())) {
                            IMechanicable v1 = (IMechanicable) v;
                            v1.getEngine().fillWithFuel(v1.getEngine().getFuel());
                        }
                    }
                }
            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }


    }

    enum EAction {
        STATUS,
        SEAT,
        MOVE,
        ENGINE_ON,
        ENGINE_OFF,
        FILL
    }
}
