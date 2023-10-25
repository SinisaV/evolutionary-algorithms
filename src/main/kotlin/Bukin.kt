import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

class Bukin(maxFes: Int) : Problem("Bukin", 2, maxFes) {

    init {
        lowerBound[0] = -15.0
        upperBound[0] = -5.0
        lowerBound[1] = -3.0
        upperBound[1] = 3.0
    }

    override fun evaluate(x: DoubleArray): Double {
        currentFes++
        assert(currentFes <= maxFes)

        val x1 = x[0]
        val x2 = x[1]

        val term1 = 100 * sqrt(abs(x2 - 0.01 * x1.pow(2)))
        val term2 = 0.01 * abs(x1 + 10)

        return term1 + term2
    }
}
