package com.ga.homework_i.model

import kotlin.math.pow

fun Chromosome.expense(): Double {
    return (1 + (this.x + this.y + 1).pow(2) * (19 - (14 * this.x) + 3 * (this.x).pow(2) - (14 * this.y) + (6 * this.x * this.y) + 3 * (this.y).pow(2))) *
            (30 + ((2 * this.x) - (3 * this.y)).pow(2) * (18 - (32 * this.x) + 12 * (this.x).pow(2) + (48 * this.y) - (36 * this.x * this.y) + 27 * (this.y).pow(2)))
}

fun Chromosome.get(position: Int): Double {
    return if(position == 0)
        this.x
    else
        this.y
}