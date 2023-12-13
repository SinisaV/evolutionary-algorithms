fun main() {
    val numDimens = 2
    val maxFes = 10000
    val problems = listOf(
        Sphere(numDimens, maxFes),
        Ackley(numDimens, maxFes),
        Schwefel26(numDimens, maxFes),
        Rosenbrock(numDimens, maxFes),
        Bukin(maxFes),
        CarromTable(numDimens, maxFes),
        Easom(numDimens, maxFes),
        Trid(numDimens, maxFes)
    )

    problems.forEach { problem ->
        val statistic = Statistic(problem, HillClimbing(problem, 0.5))
        statistic.run()
        //println("----")
    }

    /*val problem = Sphere(2, 1000)
    val algorithm = HillClimbing(problem, 0.5)
    algorithm.run()*/
}