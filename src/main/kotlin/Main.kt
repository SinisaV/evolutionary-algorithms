fun optimums(problem: Problem) {
    val optimum = problem.evaluate(DoubleArray(problem.numberOfDimensions){ 0.0 })
    println("Optimum ${problem.name}: $optimum")
}

fun main(args: Array<String>) {

    /*val sphere = Sphere(2, 3000)
    val solution = sphere.generateRandomSolution()
    val optimum = sphere.evaluate(doubleArrayOf(0.0, 0.0))

    println(optimum)
    println(solution)

    val algorithm1 = Algorithm(sphere)
    algorithm1.run(sphere.maxFes)
    println()*/

    val selectProblem = when (args[1].toIntOrNull() ?:0) {
        1 -> { dimensions: Int, maxFes: Int -> println("Selected problem: Sphere")
            Sphere(dimensions, maxFes) }
        2 -> { dimensions: Int, maxFes: Int -> println("Selected problem: Ackley")
            Ackley(dimensions, maxFes) }
        3 -> { dimensions: Int, maxFes: Int -> println("Selected problem: Schwefel26")
            Schwefel26(dimensions, maxFes) }
        4 -> { dimensions: Int, maxFes: Int -> println("Selected problem: Rosenbrock")
            Rosenbrock(dimensions, maxFes) }
        5 -> { dimensions: Int, maxFes: Int -> println("Selected problem: Bukin")
            Bukin(maxFes) }
        6 -> { dimensions: Int, maxFes: Int -> println("Selected problem: CarromTable")
            CarromTable(dimensions, maxFes) }
        7 -> { dimensions: Int, maxFes: Int -> println("Selected problem: Easom")
            Easom(dimensions, maxFes) }
        8 -> { dimensions: Int, maxFes: Int -> println("Selected problem: Trid")
            Trid(dimensions, maxFes) }
        else -> {
            println("Invalid input!")
            return
        }
    }

    val dimensions = args[2].toIntOrNull() ?:0
    val maxFes = args[3].toIntOrNull() ?:0

    val problem = selectProblem(dimensions, maxFes)
    val randomSearch = RandomSearch(problem)
    randomSearch.run()

    optimums(problem)
}