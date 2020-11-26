package com.mellonita.blackboxkt

import kotlin.math.pow

object Sphere4D : Problem.BoxConstrainedProblem() {

    override val name: String = "4D Sphere function"

    override val dimensionality: Int = 4

    override val bounds: Array<ClosedFloatingPointRange<Double>> = quickBounds(-5.12, 5.12)

    override val globalMinima: Double = 0.0

    override fun invoke(arguments: DoubleArray): Double {
        require(arguments.size == dimensionality) { "Dimension mismatch" }
        require(validate(arguments)) { "Out of bounds" }
        return arguments.sumByDouble { it.pow(2) }
    }
}