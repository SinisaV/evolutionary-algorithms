import kotlin.math.pow
import kotlin.math.sqrt

class Statistic (private val problem: Problem, private val runs: Int = 100) {
    fun run() {
        val allSolutions = mutableListOf<Solution>()

        for (i in 0 until runs) {
            val algorithm = HillClimbing(problem, 0.6)
            algorithm.run()
            val bestSolution = algorithm.bestSolution

            if (bestSolution != null) {
                allSolutions.add(bestSolution)
            } else {
                println("No solution found in run $i.")
            }
        }

        val minFitness = allSolutions.minOfOrNull { it.fitness }
        val mean = calculateMean(allSolutions.map { it.fitness })
        val stdDev = calculateStandardDeviation(allSolutions.map { it.fitness })

        println(problem.name + " min: " + minFitness + " mean: " + mean + " std: " + stdDev)
    }

    private fun calculateMean(data: List<Double>): Double {
        return data.average()
    }

    private fun calculateStandardDeviation(data: List<Double>): Double {
        val mean = calculateMean(data)
        val sumOfSquares = data.sumOf { (it - mean).pow(2) }
        return sqrt(sumOfSquares / data.size)
    }
}