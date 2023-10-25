import kotlin.math.pow

class Rosenbrock(numberOfDimensions: Int, maxFes: Int) : Problem("Rosenbrock", numberOfDimensions, maxFes) {

    init {
        for (i in 0 until numberOfDimensions) {
            lowerBound[i] = -5.0
            upperBound[i] = 10.0
        }
    }

    override fun evaluate(x: DoubleArray): Double {
        currentFes++
        assert(currentFes <= maxFes)

        var result = 0.0
        for (i in 0 until numberOfDimensions - 1) {
            val term1 = 100 * (x[i + 1] - x[i].pow(2)).pow(2)
            val term2 = (x[i] - 1).pow(2)
            result += term1 + term2
        }

        return result
    }
}
