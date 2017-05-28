package math


import org.junit.Assert.assertEquals
import org.junit.Test

class VectorTest {
    @Test fun testToString() {
        val x1: Vector = Vector(arrayListOf(1.0, 2.0))
        assertEquals("Vector [1.0, 2.0]", x1.toString())
    }

    @Test fun testSum() {
        val x1: Vector = Vector(arrayListOf(8.0, -9.0))
        val x2: Vector = Vector(arrayListOf(-1.0, 2.0))
        assertEquals("Vector [7.0, -7.0]", x1.sum(x2).toString())
    }

    @Test fun testDiff() {
        val x3: Vector = Vector(arrayListOf(7.0, 8.0))
        val x4: Vector = Vector(arrayListOf(-8.0, 1.0))
        assertEquals("Vector [-15.0, -7.0]", x3.diff(x4).toString())
    }

    @Test fun testScalar() {
        val x5: Vector = Vector(arrayListOf(1.5, -1.0, -0.1))
        assertEquals("Vector [3.0, -2.0, -0.2]", x5.scalar(2.0).toString())
    }

    @Test fun testMagnitude() {
        val x7: Vector = Vector(arrayListOf(8.0, -4.0, 4.0))
        assertEquals(9.798, x7.maginitude(), 0.001)
    }

    @Test fun testDirection() {
        val x6: Vector = Vector(arrayListOf(-1.0, 7.0))
        val dir = x6.direction()
        assertEquals(dir.coordinates[0], -0.141, 0.001)
        assertEquals(dir.coordinates[1], 0.990, 0.001)
    }
}