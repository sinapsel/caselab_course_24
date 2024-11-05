package org.caselab.task2;

/*
 * Создайте класс, который описывает вектор (в трёхмерном пространстве).
 * У него должны быть:
 * [+] конструктор с параметрами в виде списка координат x, y, z
 * [+] метод, вычисляющий длину вектора. Корень можно посчитать с помощью Math.sqrt()
 * [+] метод, вычисляющий скалярное произведение
 * [+] метод, вычисляющий векторное произведение с другим вектором
 * [+] метод, вычисляющий угол между векторами (или косинус угла)
 * [+] методы для суммы и разности
 * [+] статический метод, который принимает целое число N, и возвращает массив случайных векторов
 * размером N.
 * [+] Если метод возвращает вектор, то он должен возвращать новый объект, а не менять базовый. То есть,
 * вектор должен быть неизменяемым (immutable) объектом как String.
 */


import java.util.Objects;

public class Vector3 {
    private final double x, y, z;

    Vector3 (double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    Vector3() {
        this(0, 0, 0);
    }

    public double getLength() {
        return Math.sqrt(x*x + y*y + z*z);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vector3 vector3)) return false;
        return Double.compare(x, vector3.x) == 0
                && Double.compare(y, vector3.y) == 0
                && Double.compare(z, vector3.z) == 0;
    }

    @Override
    public String toString() {
        return String.format("{%f, %f, %f}", x, y, z);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    public double getDotProduct(Vector3 other) {
        return x*other.x + y*other.y + z*other.z;
    }

    public Vector3 getCrossProduct(Vector3 other) {
        return new Vector3(
                y*other.z - z*other.y,
                z*other.x - x*other.z,
                x*other.y - y*other.x
        );
    }

    public double getCosineBetween(Vector3 other) {
        double length = getLength();
        double otherLength = other.getLength();
        if (length * otherLength == 0) return 0;
        return getDotProduct(other)/(length * otherLength);
    }

    public double getAngleBetween(Vector3 other) {
        return Math.acos(getCosineBetween(other));
    }

    public Vector3 add(Vector3 other) {
        return new Vector3(
                x+other.x,
                y+other.y,
                z+other.z
        );
    }

    public Vector3 subtract(Vector3 other) {
        return new Vector3(
                x-other.x,
                y-other.y,
                z-other.z
        );
    }

    public static Vector3[] generateRandomVectors(int N) {
        Vector3[] vectors = new Vector3[N];
        for (int i = 0; i < N; i++) {
            vectors[i] = new Vector3(
                    Math.random(),
                    Math.random(),
                    Math.random()
            );
        }
        return vectors;
    }

}
