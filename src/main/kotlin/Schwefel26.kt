import kotlin.math.abs
import kotlin.math.sin
import kotlin.math.sqrt

class Schwefel26(numberOfDimensions: Int, maxFes: Int) : Problem("Schwefel26", numberOfDimensions, maxFes) {

    init {
        for (i in 0 until numberOfDimensions) {
            lowerBound[i] = -500.0
            upperBound[i] = 500.0
        }
    }

    override fun evaluate(x: DoubleArray): Double {
        currentFes++
        assert(currentFes <= maxFes)

        var result = 0.0
        for (i in 0 until numberOfDimensions) {
            result += x[i] * sin(sqrt(abs(x[i])))
        }

        return -result
    }
}
