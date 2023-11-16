class RandomSearch(private val problem: Problem) : Algorithm() {
    override fun run() {
        bestSolution = null
        problem.currentFes = 0
        while (problem.currentFes < problem.maxFes) {
            val solution = problem.generateRandomSolution()
            val fitness = problem.evaluate(solution.x)

            if (bestSolution == null || fitness < bestSolution!!.fitness) {
                bestSolution = Solution(solution.x.copyOf(), fitness)
                println("${problem.currentFes}. ${bestSolution.toString()}")
            }
        }

        println("Rezultat = ${bestSolution.toString()}")
    }
}
