package com.mellonita.blackboxkt

import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.pow

/**
 * 5D Rastrigin function
 */
object Rastrigin5D : Problem.BoxConstrainedProblem() {

    override val name: String = "Rastrigin function"

    override val dimensionality: Int = 5

    override val bounds: Array<ClosedFloatingPointRange<Double>> = Array(dimensionality) { (-5.12).rangeTo(5.12) }

    override val globalMinima: Double = 0.0

    override fun invoke(arguments: DoubleArray): Double {
        require(arguments.size == dimensionality) { "Dimension mismatch" }
        require(validate(arguments)) { "Invalid arguments" }
        @Suppress("LocalVariableName") val A = 10
        return A * dimensionality + arguments.sumByDouble { x -> x.pow(2) - A * cos(2 * PI * x) }
    }

}
