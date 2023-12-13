class ParticleSolution(x: DoubleArray, fitness: Double, var velocity: DoubleArray, var pBest: DoubleArray) : Solution(x, fitness) {
    override fun toString(): String {
        return "ParticleSolution(x=${x.joinToString(", ")  { "%.2f".format(it) }}, " +
                "fitness=${String.format("%.4f", fitness)}, velocity=${velocity.joinToString(", ")  { "%.2f".format(it) }})" +
                "pBest=${pBest.joinToString(", ")  { "%.2f".format(it) }})"
    }
}