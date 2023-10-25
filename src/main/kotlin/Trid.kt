import kotlin.math.pow

class Trid(numberOfDimensions: Int, maxFes: Int) : Problem("Trid", numberOfDimensions, maxFes) {

    init {
        for (i in 0 until numberOfDimensions) {
            lowerBound[i] = -(numberOfDimensions * numberOfDimensions).toDouble()
            upperBound[i] = (numberOfDimensions * numberOfDimensions).toDouble()
        }
    }

    override fun evaluate(x: DoubleArray): Double {
        currentFes++
        assert(currentFes <= maxFes)

        var term1 = 0.0
        var term2 = 0.0

        for (i in 0 until numberOfDimensions) {
            term1 += (x[i] - 1).pow(2)
        }

        for (i in 1 until numberOfDimensions) {
            term2 += x[i] * x[i - 1]
        }

        return term1 - term2
    }
}
