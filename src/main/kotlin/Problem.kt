abstract class Problem(
    val name: String,
    val numberOfDimensions: Int,
    var maxFes: Int,
) {
    val lowerBound: DoubleArray = DoubleArray(numberOfDimensions)
    val upperBound: DoubleArray = DoubleArray(numberOfDimensions)
    var currentFes: Int = 0

    abstract fun evaluate(x: DoubleArray): Double

    fun generateRandomSolution(): Solution {
        val x = DoubleArray(numberOfDimensions)

        for (i in 0 until  numberOfDimensions) {
            x[i] = lowerBound[i] + (upperBound[i] - lowerBound[i]) * Math.random()
        }
        return Solution(x, evaluate(x))
    }
}