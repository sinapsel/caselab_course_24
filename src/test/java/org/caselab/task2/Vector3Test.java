package org.caselab.task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Vector3Test {

    @org.junit.jupiter.api.Test
    void getLength() {
        Assertions.assertEquals(0, new Vector3().getLength());
        Assertions.assertEquals(Math.sqrt(3), new Vector3(1,1,1).getLength());
    }

    @org.junit.jupiter.api.Test
    void getDotProduct() {
        Assertions.assertEquals(0, new Vector3(0,0,0).getDotProduct(new Vector3(0,0,0)));
        Assertions.assertEquals(0, new Vector3(0,1,0).getDotProduct(new Vector3(0,0,1)));
        Assertions.assertEquals(0, new Vector3(1,0,0).getDotProduct(new Vector3(0,0,1)));
        Assertions.assertEquals(4, new Vector3(1,2,-1).getDotProduct(new Vector3(2,1,0)));
    }

    @org.junit.jupiter.api.Test
    void getCrossProduct() {
        Assertions.assertEquals(new Vector3(), new Vector3().getCrossProduct(new Vector3()));
        Assertions.assertEquals(new Vector3(), new Vector3(1, 0, 0).
                getCrossProduct(new Vector3(2, 0, 0)));
        Assertions.assertEquals(new Vector3(5, 1, 7), new Vector3(3, -1, -2).
                getCrossProduct(new Vector3(1, 2, -1)));
    }

    @org.junit.jupiter.api.Test
    void getCosineBetween() {
        Assertions.assertEquals(0, new Vector3(0,0,0).getCosineBetween(new Vector3(0,0,0)));
        Assertions.assertEquals(0, new Vector3(0,1,0).getCosineBetween(new Vector3(0,0,1)));
        Assertions.assertEquals(1.0/Math.sqrt(2), new Vector3(2,6,0).getCosineBetween(new Vector3(8,4,0)));
    }

    @org.junit.jupiter.api.Test
    void getAngleBetween() {
        Assertions.assertEquals(Math.PI/2, new Vector3(0,0,0).getAngleBetween(new Vector3(0,0,0)));
        Assertions.assertEquals(Math.PI/2, new Vector3(0,1,0).getAngleBetween(new Vector3(0,0,1)));
        Assertions.assertTrue(Math.abs(Math.PI/4 - new Vector3(2,6,0).
                getAngleBetween(new Vector3(8,4,0))) < 1e-6);
    }

    @org.junit.jupiter.api.Test
    void add() {
        Assertions.assertEquals(new Vector3(1,2,3), new Vector3(1, 1, 1).
                add(new Vector3(0, 1, 2)));
    }

    @org.junit.jupiter.api.Test
    void subtract() {
        Assertions.assertEquals(new Vector3(1,1,1), new Vector3(1, 2, 3).
                subtract(new Vector3(0, 1, 2)));
    }

    @org.junit.jupiter.api.Test
    void generateRandomVectors() {
        Assertions.assertEquals(10, Vector3.generateRandomVectors(10).length);
    }

    @Test
    void testToString() {
        Assertions.assertEquals("{5.000000, 1.000000, 7.000000}",
                new Vector3(3, -1, -2).
                        getCrossProduct(new Vector3(1, 2, -1))
                        .toString());
    }
}