import kotlin.math.abs
import kotlin.random.Random

class PSO(private val problem: Problem, private val w: Double, private val c1: Double, private val c2: Double,
          private val popSize:Int = 20): Algorithm<ParticleSolution>() {
    private var globalBestSolution: ParticleSolution? = null
    private var particles: MutableList<ParticleSolution> = mutableListOf()

    override fun run(): ParticleSolution {
        problem.currentFes = 0

        for (i in 0 until popSize) {
            val particle = problem.generateRandomSolution()
            particle.fitness = problem.evaluate(particle.x)
            problem.currentFes++

            val pBest = particle.x.clone()

            val velocity = MutableList(problem.numberOfDimensions) {
                Random.nextDouble(-abs(problem.upperBound[it] - problem.lowerBound[it]), abs(problem.upperBound[it] - problem.lowerBound[it]))
            }

            particles.add(ParticleSolution(particle.x.clone(), particle.fitness, velocity.toDoubleArray(), pBest))

            if (globalBestSolution == null || particles[i].fitness < globalBestSolution!!.fitness) {
                globalBestSolution = ParticleSolution(
                    particles[i].x.clone(),
                    particles[i].fitness,
                    particles[i].velocity.clone(),
                    particles[i].pBest.clone()
                )
            }
            //println(globalBestSolution!!.fitness)
        }

        val terminationCriteria = (problem.maxFes - popSize) / popSize

        repeat(terminationCriteria) {
            for (i in 0 until particles.size) {
                for (d in 0 until problem.numberOfDimensions) {
                    val rp = Random.nextDouble(0.0, 1.0)
                    val rg = Random.nextDouble(0.0, 1.0)

                    // Update the particle's velocity: vi,d ← w vi,d + φp rp (pi,d-xi,d) + φg rg (gd-xi,d)
                    particles[i].velocity[d] = w * particles[i].velocity[d] +
                            c1 * rp * (particles[i].pBest[d] - particles[i].x[d]) +
                            c2 * rg * (globalBestSolution!!.x[d] - particles[i].x[d])

                    // Update the particle's position: xi ← xi + vi
                    particles[i].x[d] += particles[i].velocity[d]
                }
                if (!problem.isFeasible(particles[i])) {
                    problem.setFeasible(particles[i])
                }

                val newFitness = problem.evaluate(particles[i].x)
                problem.currentFes++
                //println("newFitness: $newFitness")
                //println("particles[i].fitness: ${particles[i].fitness}")
                if (newFitness < particles[i].fitness) {
                    particles[i].fitness = newFitness
                    particles[i].pBest = particles[i].x.clone()
                    if (particles[i].fitness < globalBestSolution!!.fitness) {

                        globalBestSolution = ParticleSolution(
                            particles[i].x.clone(),
                            particles[i].fitness,
                            particles[i].velocity.clone(),
                            particles[i].pBest.clone()
                        )
                    }
                }
            }
            bestSolution = globalBestSolution
            //println("Global Best Fitness: ${globalBestSolution!!.fitness}")
        }
        return (bestSolution as ParticleSolution?)!!
    }
}