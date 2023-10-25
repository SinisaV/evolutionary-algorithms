import kotlin.math.cos
import kotlin.math.exp
import kotlin.math.pow

class Easom(numberOfDimensions: Int, maxFes: Int) : Problem("Easom", numberOfDimensions, maxFes) {

    init {
        for (i in 0 until numberOfDimensions) {
            lowerBound[i] = -100.0
            upperBound[i] = 100.0
        }
    }

    override fun evaluate(x: DoubleArray): Double {
        currentFes++
        assert(currentFes <= maxFes)

        val x1 = x[0]
        val x2 = x[1]

        val term1 = -cos(x1) * cos(x2)
        val term2 = -exp(-(x1 - Math.PI).pow(2) - (x2 - Math.PI).pow(2))

        return term1 * exp(term2)
    }
}
