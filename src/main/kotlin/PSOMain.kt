import java.io.File

fun main() {
/*    val problems = listOf(
        Sphere(10, 20000),
        Sphere(20, 50000),
        Sphere(30, 100000),
        Ackley(10, 20000),
        Ackley(20, 50000),
        Ackley(30, 100000),
        Schwefel26(10, 20000),
        Schwefel26(20, 50000),
        Schwefel26(30, 100000),
        Rosenbrock(10, 20000),
        Rosenbrock(20, 50000),
        Rosenbrock(30, 100000),
        Trid(10, 20000),
        Trid(20, 50000),
        Trid(30, 100000),
        Bukin(20000),
        CarromTable(2, 20000),
        Easom(2, 20000)
    )

    for (problem in problems) {
        val results = mutableListOf<ParticleSolution>()

        for (run in 1..50) {
            val algorithm = PSO(problem, 0.7, 2.0, 2.0)
            val result = algorithm.run()
            results.add(result)
        }

        val outputFile = File("PSO-Vucetic-${problem.name}D${problem.numberOfDimensions}.txt")
        outputFile.printWriter().use { writer ->
            for (solution in results) {
                writer.println(solution.fitness)
            }
        }
        println("Results for ${problem.name} written to ${outputFile.name}")
    }*/

    val problem = Sphere(10, 50)
    val algorithm = PSO(problem, 0.7, 2.0, 2.0)

    val result = algorithm.run()
    println(result.fitness)
}