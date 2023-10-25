import kotlin.math.*

class Ackley(numberOfDimensions: Int, maxFes: Int) : Problem("Ackley", numberOfDimensions, maxFes) {

    init {
        for (i in 0 until numberOfDimensions) {
            lowerBound[i] = -32.768
            upperBound[i] = 32.768
        }
    }

    override fun evaluate(x: DoubleArray): Double {
        currentFes++
        assert(currentFes <= maxFes)

        val a = 20.0
        val b = 0.2
        val c = 2 * PI

        var sum1 = 0.0
        var sum2 = 0.0

        for (i in 0 until numberOfDimensions) {
            sum1 += x[i] * x[i]
            sum2 += cos(c * x[i])
        }

        val term1 = -a * exp(-b * sqrt(sum1 / numberOfDimensions))
        val term2 = -exp(sum2 / numberOfDimensions)

        return term1 + term2 + a + exp(1.0)
    }
}
