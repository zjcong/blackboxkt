package com.mellonita.blackboxkt

import kotlinx.serialization.Serializable

/**
 * Problem interface
 * @property dimensionality No. of variables
 * @property globalMinima Global minima
 */
@Serializable
sealed class Problem {

    abstract val name: String

    abstract val dimensionality: Int

    abstract val globalMinima: Double

    /**
     * Benchmark function
     * @param arguments
     */
    abstract operator fun invoke(arguments: DoubleArray): Double

    /**
     * Problem with arbitrary constraints
     */
    abstract class ConstrainedProblem : Problem() {

        /**
         * Check if the constraints are satisfied
         * @param arguments
         */
        abstract fun validate(arguments: DoubleArray): Boolean
    }

    /**
     * Box constrained problem
     * @property bounds box constraints
     */
    abstract class BoxConstrainedProblem : ConstrainedProblem() {

        abstract val bounds: Array<ClosedFloatingPointRange<Double>>

        /**
         * Check bound
         */
        override fun validate(arguments: DoubleArray): Boolean {
            require(arguments.size == bounds.size)
            arguments.indices.forEach { i ->
                if (arguments[i] !in bounds[i]) return false
            }
            return true
        }
    }
}