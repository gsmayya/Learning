package math

class Vector(coord: List<Double>) {

    init {
        if (coord.size == 0) {
            throw IllegalArgumentException("Size should be greater than 0")
        }
    }
    val coordinates  = coord
    val dimension = coord.size

    override fun toString() : String {
        return "Vector " + coordinates
    }

    override fun equals(other: Any?): Boolean {
        if (other is Vector)
            return coordinates.equals(other.coordinates)
        return false
    }

    fun sum(other: Vector) : Vector {
        if (dimension != other.dimension) throw IllegalArgumentException("Vectors need to be same length")
        return Vector(
                coordinates.mapIndexed { index, d -> other.coordinates[index] + d }
        )
    }

    fun diff(other: Vector) : Vector {
        if (dimension != other.dimension) throw IllegalArgumentException("Vectors need to be same length")
        return Vector(
                coordinates.mapIndexed { index, d -> other.coordinates[index] - d }
        )
    }

    fun scalar(scal : Double) : Vector {
        return Vector(coordinates.map { x -> x * scal }.toList())
    }

    fun maginitude() : Double {
        return Math.sqrt(coordinates.map { x -> x * x }.sum())
    }

    fun direction() : Vector {
        return scalar(1.0/maginitude())
    }

    fun dot(other : Vector) : Double {
        return coordinates.mapIndexed { index, d -> other.coordinates[index] * d }.sum()
    }
}