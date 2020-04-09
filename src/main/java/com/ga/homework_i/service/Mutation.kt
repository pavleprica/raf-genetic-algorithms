package com.ga.homework_i.service

import com.ga.homework_i.model.Chromosome
import com.ga.homework_i.model.ConfigConstants
import com.ga.homework_i.model.Constraint
import kotlin.random.Random

class Mutation {

    fun mutate(chromosome: Chromosome, constraint: Constraint): Chromosome {

        if(Random.nextLong() < ConfigConstants.rate) {
            chromosome.x = Random.nextDouble(constraint.leftConstraint, constraint.rightConstraint)
            chromosome.y = Random.nextDouble(constraint.leftConstraint, constraint.rightConstraint)
        }

        return chromosome
    }
}