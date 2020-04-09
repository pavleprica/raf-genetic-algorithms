package com.ga.homework_i.model

import kotlin.math.pow

/**
 * This file contains a function of the expense math function. Every chromosome can calculate it's
 * expense easily this way.
 */

/**
 * Golden-Price expense
 */
fun Chromosome.expense(): Double {
    return (1 + (this.x + this.y + 1).pow(2) * (19 - (14 * this.x) + 3 * (this.x).pow(2) - (14 * this.y) + (6 * this.x * this.y) + 3 * (this.y).pow(2))) *
            (30 + ((2 * this.x) - (3 * this.y)).pow(2) * (18 - (32 * this.x) + 12 * (this.x).pow(2) + (48 * this.y) - (36 * this.x * this.y) + 27 * (this.y).pow(2)))
}