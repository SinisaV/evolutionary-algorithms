class HillClimbing(private val problem: Problem, private val stepSize : Double) : Algorithm<Unit>() {
    private var globalBestSolution: Solution? = null

    override fun run() {
        problem.currentFes = 0
        bestSolution = problem.generateRandomSolution()
        bestSolution!!.fitness = problem.evaluate(bestSolution!!.x)
        problem.currentFes++
        while (problem.currentFes < problem.maxFes) {
            val neighbor = getBestNeighbor(bestSolution!!)
            if (neighbor.fitness < bestSolution!!.fitness) {
                bestSolution = neighbor
                if (globalBestSolution == null || neighbor.fitness < globalBestSolution!!.fitness) {
                    globalBestSolution = neighbor
                }
                //println("${problem.currentFes}. ${bestSolution.toString()}")
            } else {
                // Generate a new solution
                bestSolution = problem.generateRandomSolution()
            }
            problem.currentFes += problem.numberOfDimensions
        }

        //println("Result = ${globalBestSolution.toString()}")
    }

    private fun getBestNeighbor(currentSolution: Solution): Solution {
        val neighbors = mutableListOf<Solution>()

        if (problem.numberOfDimensions > problem.maxFes - problem.currentFes) {
            for (i in 0 until problem.numberOfDimensions) {
                val neighbor = Solution(currentSolution.x.copyOf(), currentSolution.fitness)
                neighbor.x[i] += stepSize

                if (!problem.isFeasible(neighbor)) {
                    problem.setFeasible(neighbor)
                }
                neighbor.fitness = problem.evaluate(neighbor.x)
                neighbors.add(neighbor)
            }
        }
        else {
            for (i in 0 until problem.numberOfDimensions) {
                val neighbor1 = Solution(currentSolution.x.copyOf(), currentSolution.fitness)
                val neighbor2 = Solution(currentSolution.x.copyOf(), currentSolution.fitness)
                neighbor1.x[i] += stepSize
                neighbor2.x[i] -= stepSize

                if (!problem.isFeasible(neighbor1)) {
                    problem.setFeasible(neighbor1)
                }
                if (!problem.isFeasible(neighbor2)) {
                    problem.setFeasible(neighbor2)
                }
                neighbor1.fitness = problem.evaluate(neighbor1.x)
                neighbor2.fitness = problem.evaluate(neighbor2.x)
                neighbors.add(neighbor1)
                neighbors.add(neighbor2)
            }
        }
        return neighbors.minByOrNull { it.fitness }!!
    }
}