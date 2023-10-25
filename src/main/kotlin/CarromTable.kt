import kotlin.math.abs
import kotlin.math.sin
import kotlin.math.sqrt

class CarromTable(numberOfDimensions: Int, maxFes: Int) : Problem("CarromTable", numberOfDimensions, maxFes) {

    init {
        for (i in 0 until numberOfDimensions) {
            lowerBound[i] = -10.0
            upperBound[i] = 10.0
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
