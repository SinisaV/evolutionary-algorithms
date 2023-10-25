class Sphere(numberOfDimensions: Int, maxFes: Int): Problem("Sphere", numberOfDimensions, maxFes) {

    init {
        for (i in 0 until numberOfDimensions) {
            lowerBound[i] = -100.0
            upperBound[i] = 100.0
        }
    }

    override fun evaluate(x: DoubleArray): Double {
        currentFes++
        assert(currentFes <= maxFes)

        var fitness = 0.0
        for (i in 0 until numberOfDimensions) {
            fitness += x[i] * x[i]
        }

        return fitness
    }
}