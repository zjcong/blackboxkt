package com.mellonita.blackboxkt

import kotlin.math.*

@Suppress("ClassName")
object XinSheYangN4_10D : Problem.BoxConstrainedProblem() {
    override val name: String = "10D Xin-She Yang N.4 Function"
    override val dimensionality: Int = 10
    override val bounds: Array<ClosedFloatingPointRange<Double>> = quickBounds(-10.0, 10.0)

    override val globalMinima: Double = -1.0

    override fun invoke(arguments: DoubleArray): Double {
        require(arguments.size == dimensionality) { "Dimension mismatch" }
        require(validate(arguments)) { "Invalid arguments" }

        val p1 = arguments.sumByDouble { x -> sin(x).pow(2) } - exp(-(arguments.sumByDouble { x -> x.pow(2) }))
        val p2 = exp(-(arguments.sumByDouble { x -> sin(sqrt(abs(x))).pow(2) }))
        return p1 * p2
    }
}