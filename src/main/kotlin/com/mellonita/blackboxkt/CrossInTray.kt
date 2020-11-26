package com.mellonita.blackboxkt

import kotlin.math.*

object CrossInTray : Problem.BoxConstrainedProblem() {
    override val name: String = "Cross-In-Tray Function"

    override val dimensionality: Int = 2

    override val bounds: Array<ClosedFloatingPointRange<Double>> = quickBounds(-10.0, 10.0)

    override val globalMinima: Double = -2.06261

    override fun invoke(arguments: DoubleArray): Double {
        require(arguments.size == dimensionality) { "Dimension mismatch" }
        require(validate(arguments)) { "Invalid arguments" }

        val x = arguments[0]
        val y = arguments[1]
        return -0.0001 * (abs(
            sin(x) * sin(y) * exp(
                abs(100 - sqrt(x.pow(2) + y.pow(2)) / PI)
            )
        ) + 1.0).pow(0.1)
    }
}